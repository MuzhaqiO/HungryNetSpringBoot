package com.hungerNet.Hunger.Net.security;

import com.hungerNet.Hunger.Net.jwtUtil.JwtTokenFilter;
import com.hungerNet.Hunger.Net.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private final UserRepo userRepo;
    private final JwtTokenFilter jwtTokenFilter;

    public SecurityConfiguration(UserRepo userRepo, JwtTokenFilter jwtTokenFilter) {
        this.userRepo = userRepo;
        this.jwtTokenFilter = jwtTokenFilter;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
                web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/api/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().formLogin().disable()
                .httpBasic().disable()
                .addFilterBefore(
                        jwtTokenFilter,
                        UsernamePasswordAuthenticationFilter.class
                );
//        http
//                .exceptionHandling()
//                .authenticationEntryPoint(
//                        (request, response, ex) -> {
//                            response.sendError(
//                                    HttpServletResponse.SC_UNAUTHORIZED,
//                                    ex.getMessage()
//                            );
//                        }
//                )
//                .and();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.cors().and().csrf().disable();
//
//        http
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and();
//
//        http.authorizeRequests()
//                .antMatchers("/v2/api-docs",
//                "/configuration/ui",
//                "/swagger-resources/**",
//                "/configuration/security",
//                "/swagger-ui.html",
//                "/webjars/**",
//                        "/api/auth/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and().formLogin().disable()
//                .httpBasic().disable()
//                .addFilterBefore(
//                        jwtTokenFilter,
//                        UsernamePasswordAuthenticationFilter.class
//                );
//        //        http
////                .exceptionHandling()
////                .authenticationEntryPoint(
////                        (request, response, ex) -> {
////                            response.sendError(
////                                    HttpServletResponse.SC_UNAUTHORIZED,
////                                    ex.getMessage()
////                            );
////                        }
////                )
////                .and();
//
//        return http.build();
//    }
}
