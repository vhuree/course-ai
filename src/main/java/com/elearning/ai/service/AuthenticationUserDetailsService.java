package com.elearning.ai.service;

import com.elearning.ai.model.AuthenticationUser;
import com.elearning.ai.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.elearning.ai.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    public AuthenticationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("user1 = ");
        User user = userRepository.findByEmail(username).
                orElseThrow(() ->   new UsernameNotFoundException("No user found with the given id"));
        return new AuthenticationUser(user);    }
}
