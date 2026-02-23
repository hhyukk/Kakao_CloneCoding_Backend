package com.kakao.clone.domain.user.service;

import com.kakao.clone.domain.user.dto.SignUpRequestDto;
import com.kakao.clone.domain.user.entity.User;
import com.kakao.clone.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입 비즈니스 로직 구현 (데이터 변경이 일어나므로 Transactional 적용)
    @Transactional
    public Long signUp(SignUpRequestDto requestDto) {
        // 이메일 중복 체크
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        // 비밀번호 암호화
        String encodePassword = passwordEncoder.encode(requestDto.getPassword());

        // User 엔티티 생성 및 저장
        User user=User.builder()
                .email(requestDto.getEmail())
                .password(encodePassword)
                .nickname(requestDto.getNickname())
                .build();

        return userRepository.save(user).getId();
    }
}
