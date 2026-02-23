package com.kakao.clone.domain.user.repository;

import com.kakao.clone.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // 회원가입 시 이미 가입된 이메일인지 확인하기
    boolean existsByEmail(String email);
}
