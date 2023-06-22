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

    @PostMapping("/api/sympathy")
    public ResponseEntity<Sympathy> addSympathy(@RequestBody AddSympathyRequest request) {
        for (Sympathy sympathy : sympathyService.findAll()) {
            if (sympathy.getDiaryNo() == request.getDiaryNo() && sympathy.getUserNo() == request.getUserNo()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .build();
            }
        }
        Sympathy savedSympathy = sympathyService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedSympathy);
    }

    @GetMapping("/api/sympathy/by-user/{userNo}")
    public ResponseEntity<List<SympathyResponse>> findAllSympathyByUser(@PathVariable int userNo) {
        List<SympathyResponse> sympathy = sympathyService.findAll()
                .stream()
                .filter(s -> s.getUserNo() == userNo)
                .map(SympathyResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(sympathy);
    }

}
