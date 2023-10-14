package org.fire.controller;

import lombok.RequiredArgsConstructor;
import org.fire.domain.DiaryCover;
import org.fire.dto.*;
import org.fire.service.DiaryCoverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DiaryCoverApiController {

    private final DiaryCoverService diaryCoverService;

    @PostMapping("/api/diary-covers")    // 다이어리 생성
    public ResponseEntity<DiaryCover> addDiaryCover(@RequestBody AddDiaryCoverRequest request){
        DiaryCover savedDiaryCover = diaryCoverService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedDiaryCover);
    }

    @GetMapping("/api/diary-covers") // 다이어리 전체 조회
    public ResponseEntity<List<DiaryCoverResponse>> findAllDiaryCover(){
        List<DiaryCoverResponse> diaryCovers= diaryCoverService.findAll()
                .stream()
                .map(DiaryCoverResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(diaryCovers);
    }

    // diarycover detail
    @GetMapping("/api/diary-covers/{id}")
    public ResponseEntity<DiaryCoverDetailResponse> findDiaryCover(@PathVariable long id){
        DiaryCover diaryCover= diaryCoverService.findById(id);

        return ResponseEntity.ok()
                .body(new DiaryCoverDetailResponse(diaryCover));
    }

    @DeleteMapping("/api/diary-covers/{id}")
    public ResponseEntity<Void> deleteDiaryCover(@PathVariable long id){
        diaryCoverService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/diary-covers/{id}")
    public ResponseEntity<DiaryCover> updateDiaryCover(@PathVariable long id,
                                                       @RequestBody UpdateDiaryCoverRequest request){
        DiaryCover updateDiaryCover= diaryCoverService.update(id, request);

        return ResponseEntity.ok()
                .body(updateDiaryCover);
    }
}
