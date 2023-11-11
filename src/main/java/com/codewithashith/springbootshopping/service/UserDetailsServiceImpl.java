package com.codewithashith.springbootshopping.service;

import com.codewithashith.springbootshopping.model.AppUser;
import com.codewithashith.springbootshopping.model.Role;
import com.codewithashith.springbootshopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found with username: " + username);
        });
        if (user != null) {
            return new User(user.getName(), user.getPassword(),
                    buildSimpleGrantedAuthorities(user.getRoles()));
        }
        return null;
    }

    private static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final Role role) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        return authorities;
    }
}
