package org.fire.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.fire.domain.User;
import org.fire.dto.AddUserRequest;
import org.fire.dto.UpdateUserRequest;
import org.fire.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User save(AddUserRequest request) {
        return userRepository.save(request.toEntity());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(long id) { // 기본키 userNo가 들어옴
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User update(long id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        user.update(request.getUserPw(), request.getUserName(), request.getUserEmail());

        return user;
    }
}
