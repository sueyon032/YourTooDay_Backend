package org.fire.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no", updatable = false)
    private Long userNo; // 기본키

    @Column(name = "user_id", nullable = false)
    private String userId; // 유저 아이디

    @Column(name = "user_pw", nullable = false)
    private String userPw; // 유저 비밀번호

    @Column(name = "user_name", nullable = false)
    private String userName; // 유저 이름(닉네임)

    @Column(name = "user_email", nullable = false)
    private String userEmail; // 유저 이메일

    // 카카오 로그인
    @Column(name = "kakao_id", nullable = false)
    private Long kakaoId; // 카카오 유저 아이디

    @Builder
    public User(String userId, String userPw, String userName, String userEmail, Long kakaoId) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userEmail = userEmail;
        this.kakaoId = kakaoId;
    }

    // userId값은 수정이 불가하도록 제외
    public void update(String userPw, String userName, String userEmail) {
        this.userPw = userPw;
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
