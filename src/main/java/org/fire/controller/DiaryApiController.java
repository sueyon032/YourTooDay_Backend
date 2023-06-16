package org.fire.controller;

import lombok.RequiredArgsConstructor;
import org.fire.domain.Diary;
import org.fire.dto.AddDiaryRequest;
import org.fire.dto.DiaryResponse;
import org.fire.repository.DiaryRepository;
import org.fire.service.DiaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DiaryApiController {

    private final DiaryService diaryService;

    @PostMapping("/api/diaries")
    public ResponseEntity<Diary> addDiary(@RequestBody AddDiaryRequest request) {
        Diary savedDiary = diaryService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedDiary);
    }

    @GetMapping("/api/diaries") // 일기 전체 조회
    public ResponseEntity<List<DiaryResponse>> findAllDiaries() {
        List<DiaryResponse> diaries = diaryService.findAll()
                .stream()
                .map(DiaryResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(diaries);
    }

    @GetMapping("/api/diaries/{id}") // 일기 건별 조회
    public ResponseEntity<DiaryResponse> findDiaries(@PathVariable long id) {
        Diary diary = diaryService.findById(id);

        return ResponseEntity.ok()
                .body(new DiaryResponse(diary));
    }

    @DeleteMapping("/api/diaries/{id}") // 일기 삭제
    public ResponseEntity<Void> deleteDiaries(@PathVariable long id) {
        diaryService.delete(id);

        return ResponseEntity.ok()
                .build();
    }
}
