package com.sparta.springhw1.service;

import com.sparta.springhw1.domain.UserEntity;
import com.sparta.springhw1.dto.InsertUserRequestDto;
import com.sparta.springhw1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;


@RequiredArgsConstructor
@Transactional
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean checkExistId(String userId) {
        return userRepository.existsByUserId(userId);
    }

    private boolean checkPwPwCheck(String password, String passwordCheck) {
        if(password.equals(passwordCheck)) {
            return true;
        } else {
            return false;
        }
    }

//    private boolean checkIdForm(String userId) {
//        String idPattern = "^[a-z|A-Z|0-9]*$";
//
//        return userId.length() >= 3 && Pattern.matches(idPattern, userId);
//    }

    private boolean checkPwForm(String userId, String password) {
        return password.length() >= 4 && !password.contains(userId);
    }

    public UserEntity signUp(InsertUserRequestDto insertUserRequestDto) {
        String userId = insertUserRequestDto.getId();
        String name = insertUserRequestDto.getName();
        String password = insertUserRequestDto.getPassword();
        String passwordCheck = insertUserRequestDto.getPasswordCheck();
        String encodingPassword = passwordEncoder.encode(password);

        if(!checkPwPwCheck(password, passwordCheck)) {
            throw new IllegalStateException("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

//        if(!checkIdForm(userId)) {
//            throw new IllegalStateException("아이디 형식을 다시 확인해 주세요.");
//        }

        if(!checkPwForm(userId, password)) {
            throw new IllegalStateException("비밀번호는 아이디와 같은 값이 포함되지 않아야 합니다.");
        }

        UserEntity user = new UserEntity(userId, name, encodingPassword);

        return userRepository.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        System.out.println(id);
        UserEntity user = userRepository.findById(id).get();

        if(user == null) {
            throw new UsernameNotFoundException(id);
        }

        System.out.println("로그인 성공");

        return User.builder()
                .username(user.getName())
                .password(user.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }

//    public boolean signIn(SelectUserRequestDto selectUserRequestDto) {
//        String id = selectUserRequestDto.getId();
//        String password = passwordEncoder.encode(selectUserRequestDto.getPassword());
//
//        UserEntity user = userRepository.findById(id).get();
//
//        if(user.getPassword().equals(password)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
