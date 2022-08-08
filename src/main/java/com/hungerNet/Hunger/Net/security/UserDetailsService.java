package com.hungerNet.Hunger.Net.security;

import com.hungerNet.Hunger.Net.model.User;
import com.hungerNet.Hunger.Net.repository.UserRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, IllegalStateException {
        User user = userRepo.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Bad credentials");
        }

        MyUserDetails userDetail = new MyUserDetails();
        userDetail.setUsername(username);
        userDetail.setPassword(user.getPassword());
        userDetail.setRole(user.getRoleName().toString());
        return userDetail;
    }

    private HttpServletRequest getRequest() throws Exception {
        try {
            final RequestAttributes currentRequestAttributes = RequestContextHolder.currentRequestAttributes();
            return ((ServletRequestAttributes) currentRequestAttributes).getRequest();
        } catch (final IllegalStateException e) {
            throw new IllegalStateException("Cannot access current request: " + e.getMessage());
        }
    }
}
