package com.kakao.clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KakaoCloneCodingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakaoCloneCodingBackendApplication.class, args);
	}

}
