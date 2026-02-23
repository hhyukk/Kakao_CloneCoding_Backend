package com.kakao.clone.domain.user.controller;

import com.kakao.clone.domain.user.dto.SignUpRequestDto;
import com.kakao.clone.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입 API 엔드포인트 (@Valid로 DTO 데이터 검증)
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequestDto requestDto){
        userService.signUp(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입이 성공적으로 완료되었습니다.");
    }
}
