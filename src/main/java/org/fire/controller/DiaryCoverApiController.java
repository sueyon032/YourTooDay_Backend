package org.fire.controller;

import lombok.RequiredArgsConstructor;
import org.fire.domain.DiaryCover;
import org.fire.dto.AddDiaryCoverRequest;
import org.fire.service.DiaryCoverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DiaryCoverApiController {

    private final DiaryCoverService diaryCoverService;

    @PostMapping("/api/diary-cover")    // 다이어리 생성
    public ResponseEntity<DiaryCover> addDiaryCover(@RequestBody AddDiaryCoverRequest request){
        DiaryCover savedDiaryCover = diaryCoverService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedDiaryCover);
    }
}
