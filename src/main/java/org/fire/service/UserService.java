package org.fire.service;

import lombok.RequiredArgsConstructor;
import org.fire.domain.User;
import org.fire.dto.AddUserRequest;
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
}
