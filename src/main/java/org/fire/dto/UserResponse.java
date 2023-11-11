package org.fire.dto;

import lombok.Getter;
import org.fire.domain.User;

@Getter
public class UserResponse {

    private final String userId;
    private final String userPw;
    private final String userName;
    private final String userEmail;
    private final Long kakaoId;
    public UserResponse(User user) {
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();
        this.userName =  user.getUserName();
        this.userEmail = user.getUserEmail();
        this.kakaoId = user.getKakaoId();

    }
}
