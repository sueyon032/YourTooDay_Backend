package org.fire.controller;

import lombok.RequiredArgsConstructor;
import org.fire.domain.Sympathy;
import org.fire.dto.AddSympathyRequest;
import org.fire.dto.SympathyResponse;
import org.fire.service.SympathyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SympathyController {

    private final SympathyService sympathyService;

    @PostMapping("/api/sympathy") // 공감 추가
    public ResponseEntity<Sympathy> addSympathy(@RequestBody AddSympathyRequest request) {
        for (Sympathy sympathy : sympathyService.findAll()) {
            if (sympathy.getDiaryNo().equals(request.getDiaryNo()) && sympathy.getUserNo().equals(request.getUserNo())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .build();
            }
        }

        Sympathy savedSympathy = sympathyService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedSympathy);
    }

    @GetMapping("/api/sympathy/by-user/{userNo}") // userNo에 해당하는 공감 정보 조회
    public ResponseEntity<List<SympathyResponse>> findAllSympathyByUser(@PathVariable Long userNo) {
        List<SympathyResponse> sympathy = sympathyService.findAll()
                .stream()
                .filter(s -> s.getUserNo().equals(userNo))
                .map(SympathyResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(sympathy);
    }

}
