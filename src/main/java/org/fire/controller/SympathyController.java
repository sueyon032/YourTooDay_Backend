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
            if (sympathy.getDiaryNo() == request.getDiaryNo() && sympathy.getUserNo() == request.getUserNo()) { // 한 유저가 같은 일기에 공감을 남길 경우
                return ResponseEntity.status(HttpStatus.BAD_REQUEST) // 오류를 낸다
                        .build();
            }
        }
        Sympathy savedSympahty = sympathyService.save(request); // 중복으로 남기는 게 아닐시에는 정상적으로 저장
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedSympahty);
    }

    // 해당 유저가 남긴 공감을 조회
    @GetMapping("/api/sympathy/by-user/{userNo}") // userNo에 해당하는 공감 정보 조회
    public ResponseEntity<List<SympathyResponse>> findAllSympathyByUser(@PathVariable int userNo) {
        List<SympathyResponse> sympathy = sympathyService.findAll()
                .stream()
                // 해당 유저에게 '남겨진' 공감 정보를 조회하는 기능으로 수정한 코드
                // .filter(s -> s.getDiaryNo() == userNo)
                .filter(s -> s.getUserNo() == userNo) // userNo와 일치하는 공감 정보만 가져올 수 있도록 필터링
                .map(SympathyResponse::new)
                // 공감 정보를 전달하기 위한 DTO 클래스인 SympathyResponse의 객체 형태로 변환
                .toList(); // 필터링과 매핑이 된 공감 정보를 리스트로 변환

        return ResponseEntity.ok()
                .body(sympathy);
    }

}
