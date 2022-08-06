package com.hungerNet.Hunger.Net.jwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public final class JwtTokenUtil {
    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    @Value("${security.jwt.secret}")
    private String secret;

    @Value("${security.jwt.expiration}")
    private Long expiration;

    private Claims getClaimsFromToken(final String token) {
        try {
            final String accessToken = token.substring("Bearer".length()).trim();
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(accessToken).getBody();
        } catch (final IllegalArgumentException | JwtException e) {
            return null;
        }
    }

    public String getUsernameFromToken(final String token) {
        final Claims claims = getClaimsFromToken(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    public Date getCreatedDateFromToken(final String token) {
        final Claims claims = getClaimsFromToken(token);
        if (claims != null) {
            return claims.getIssuedAt();
        }
        return null;
    }

    private Date generateExpirationDate() {
        return Date.from(Instant.now().plusSeconds(expiration));
    }

    private Boolean isTokenExpired(final String token) {
        final Claims claims = getClaimsFromToken(token);
        if (claims != null && claims.getExpiration() != null) {
            return claims.getExpiration().before(new Date());
        }
        return true;
    }

    private Boolean isCreatedBeforeLastPasswordReset(final Date created, final Date lastPasswordReset) {
        return lastPasswordReset != null && created.before(lastPasswordReset);
    }

    public String generateToken(final UserDetails userDetails) {
        final Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
        claims.setIssuedAt(new Date());
        claims.setExpiration(generateExpirationDate());
        return generateToken(claims);
    }

    private String generateToken(final Claims claims) {
        return Jwts.builder().setClaims(claims).signWith(SIGNATURE_ALGORITHM, secret).compact();
    }

    public Boolean canTokenBeRefreshed(final String token, final Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset) && (!isTokenExpired(token));
    }

    public String refreshToken(final String token) {
        final Claims claims = getClaimsFromToken(token);
        if (claims != null) {
            claims.setIssuedAt(new Date());
            return generateToken(claims);
        }
        return null;
    }

    public Boolean validateToken(final String token, final UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        final Date created = getCreatedDateFromToken(token);
        if (userDetails == null || username == null || created == null) {
            return false;
        }
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
}
