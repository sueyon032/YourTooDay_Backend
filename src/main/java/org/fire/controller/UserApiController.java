package org.fire.controller;

import lombok.RequiredArgsConstructor;
import org.fire.domain.User;
import org.fire.dto.AddUserRequest;
import org.fire.dto.UserResponse;
import org.fire.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/users") // 유저 생성
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request) {
        User savedUser = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @GetMapping("/api/users") // 유저 전체 조회
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        List<UserResponse> users = userService.findAll()
                .stream()
                .map(UserResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(users);
    }

    @GetMapping("/api/users/{id}") // 유저 단건 조회
    public ResponseEntity<UserResponse> findUser(@PathVariable long id) {
        User user = userService.findById(id);

        return ResponseEntity.ok()
                .body(new UserResponse(user));
    }

    @DeleteMapping("/api/users/{id}") // 유저 삭제
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.delete(id);

        return ResponseEntity.ok()
                .build();
    }
}
