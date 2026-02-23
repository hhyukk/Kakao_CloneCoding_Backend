package com.kakao.clone.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 비밀번호 암호화하기 위해 BCryptPasswordEncoder 빈 등록
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // Spring Security의 보안 필터 체인 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable) // REST API 서버이므로 CSRF 보호 비활성
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/users/signup","/api/v1/users/login").permitAll() // 회원가입, 로그인은 누구나 접근 허용
                        .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
                );
        return http.build();
    }
}
