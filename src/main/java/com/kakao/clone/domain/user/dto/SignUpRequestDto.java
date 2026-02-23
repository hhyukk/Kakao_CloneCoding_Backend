package com.kakao.clone.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    // 이메일 형식 검증 및 빈 값 방지
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    // 비밀번호 빈 값 방지 (추후 @Pattern으로 영문, 숫자 조합 규칙 추가 가능)
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;

    // 닉네임 빈 값 방지
    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    private String nickname;
}
