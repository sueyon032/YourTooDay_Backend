package org.fire.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.fire.domain.Diary;
import org.fire.dto.AddDiaryRequest;
import org.fire.dto.DiaryDetailResponse;
import org.fire.dto.UpdateDiaryRequest;
import org.fire.repository.DiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// 클라이언트로부터 받은 요청을 처리하기 위해 DiaryRepository를 사용하여 데이터베이스와 상호 작용
// DiaryRepository를 사용하여 엔티티의 CRUD 작업을 수행하고 필요한 비즈니스 로직을 적용
@RequiredArgsConstructor
@Service
public class DiaryService {

    // 데이터베이스 작업을 처리하기 위해 DiaryRepository를 주입받음.
    private final DiaryRepository diaryRepository;

    // save(AddDiaryRequest request): 새로운 일기를 추가하는 메서드
    // AddDiaryRequest 객체를 받아서, 이를 Diary 엔티티로 변환한 후
    // diaryRepository.save() 메서드를 사용하여 데이터베이스에 저장, 그리고 저장된 엔티티를 반환
    public Diary save(AddDiaryRequest request) {
        return diaryRepository.save(request.toEntity());
    }


    // findAll(): 모든 일기 목록을 조회하는 메서드
    // diaryRepository.findAll()을 호출하여 데이터베이스에서 모든 일기 조회 후, List형으로 반환 (일기는 여러개여서)
    public List<Diary> findAll() {
        return diaryRepository.findAll();
    }

    // findById(long id): 주어진 id에 해당하는 일기를 조회하는 메서드
    // diaryRepository.findById(id)를 호출하여 해당 id를 가지는 일기를 찾아 반환
    // 만약 해당하는 일기가 없을 경우 예외를 던짐
    public Diary findById(long id) {
        return diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }


    // delete(long id): 주어진 id에 해당하는 일기를 삭제하는 메서드
    // diaryRepository.deleteById(id)를 호출하여 해당 id를 가지는 일기를 삭제함
    public void delete(long id) {
        diaryRepository.deleteById(id);
    }

    // update(long id, UpdateDiaryRequest request): 주어진 id에 해당하는 일기를 업데이트하는 메서드
    // diaryRepository.findById(id)를 사용하여 해당 id를 가지는 일기를 조회하고,
    // 업데이트할 내용을 request에서 가져와 diary.update() 메서드를 호출하여 엔티티를 업데이트한 후, 엔티티를 반환
    @Transactional
    public Diary update(long id, UpdateDiaryRequest request) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        diary.update(request.getDiaryTitle(), request.getDiaryContent());

        return diary;
    }
}
