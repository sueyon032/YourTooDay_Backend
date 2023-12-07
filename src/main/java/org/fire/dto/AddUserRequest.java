package org.fire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fire.domain.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddUserRequest {

    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
    private Long kakaoId;

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userEmail(userEmail)
                .kakaoId(kakaoId)
                .build();
    }
}

