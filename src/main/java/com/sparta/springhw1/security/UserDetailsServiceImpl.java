package com.sparta.springhw1.security;

import com.sparta.springhw1.domain.UserEntity;
import com.sparta.springhw1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        UserEntity user = userRepository.findById(id).get();

        if(user == null) {
            throw new UsernameNotFoundException(id);
        }

        return new UserDetailsImpl(user);
    }
}
