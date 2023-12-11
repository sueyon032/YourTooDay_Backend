package org.fire.controller;

import lombok.RequiredArgsConstructor;
import org.fire.domain.Diary;
import org.fire.domain.DiaryCover;
import org.fire.dto.*;
import org.fire.repository.DiaryRepository;
import org.fire.service.DiaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// 클라이언트의 API 요청을 처리하고, 해당 요청에 필요한 서비스 메서드(DiaryService 클래스에 있는)를 호출
// 요청을 처리하고, 클라이언트에게 응답을 보내기 위해 DiaryResponse 클래스를 사용하여 데이터를 포장한 후 반환
@RequiredArgsConstructor
@RestController
public class DiaryApiController {

    private final DiaryService diaryService;

    // POST 요청을 받아 새로운 일기를 추가
    // 클라이언트가 JSON 형식의 데이터를 요청 본문에 담아 보내면, 이 데이터를 AddDiaryRequest 객체로 매핑하고
    // diaryService.save(request)를 호출하여 일기를 저장.
    // ResponseEntity로 응답을 생성하여 HTTP 상태 코드 201(생성됨)과 함께 저장된 일기를 클라이언트에 반환
    @PostMapping("/api/diaries")
    public ResponseEntity<Diary> addDiary(@RequestBody AddDiaryRequest request) {
        Diary savedDiary = diaryService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedDiary);
    }

    // GET 요청을 받아 일기 전체를 조회
    @GetMapping("/api/diaries")
    public ResponseEntity<List<DiaryResponse>> findAllDiaries() {
        List<DiaryResponse> diaries = diaryService.findAll()
                // 일기 목록을 스트림으로 변환
                .stream()
                // Diary 엔티티를 DiaryResponse로 변환
                .map(DiaryResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(diaries);
    }

    // GET 요청을 받아 일기를 건별로 조회
    // 해당 ID의 일기를 diaryService.findById(id)로 조회한 후
    // DiaryResponse로 변환하여 반환
    /* @GetMapping("/api/diaries/{id}")
    public ResponseEntity<DiaryResponse> findDiary(@PathVariable long id) {
        Diary diary = diaryService.findById(id);

        return ResponseEntity.ok()
                .body(new DiaryResponse(diary));
    } */

    // DiaryDetailResponse로 변한하여 반환 (일기 보기 화면)
    @GetMapping("/api/diaries/{id}")
    public ResponseEntity<DiaryDetailResponse> findDiary(@PathVariable long id){
        Diary diary = diaryService.findById(id);

        return ResponseEntity.ok()
                .body(new DiaryDetailResponse(diary));
    }

    /* @GetMapping("/api/diaries/{diaryCoverNo}/{id}")
    public ResponseEntity<DiaryDetailResponse> findDiary(
            @PathVariable long diaryCoverNo,
            @PathVariable long id) {
        Optional<Diary> diaryOptional = diaryService.findByDiaryCoverAndId(diaryCoverNo, id);

        if (diaryOptional.isPresent()) {
            Diary diary = diaryOptional.get();
            return ResponseEntity.ok().body(new DiaryDetailResponse(diary));
        } else {
            return ResponseEntity.notFound().build();
        }
    } */


    // DELETE 요청을 받아 일기를 건별로 삭제
    @DeleteMapping("/api/diaries/{id}")
    public ResponseEntity<Void> deleteDiary(@PathVariable long id) {
        diaryService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    // PUT 요청을 받아 일기를 건별로 수정(업데이트)
    @PutMapping("/api/diaries/{id}")
    public ResponseEntity<Diary> updateDiary(@PathVariable long id,
                                             @RequestBody UpdateDiaryRequest request) {
        Diary updatedDiary = diaryService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedDiary);
    }
}
