package org.fire.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.fire.domain.Diary;
import org.fire.dto.AddDiaryRequest;
import org.fire.dto.UpdateDiaryRequest;
import org.fire.repository.DiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public Diary save(AddDiaryRequest request) {
        return diaryRepository.save(request.toEntity());
    }

    public List<Diary> findAll() {
        return diaryRepository.findAll();
    }

    public Diary findById(long id) {
        return diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        diaryRepository.deleteById(id);
    }

    @Transactional
    public Diary update(long id, UpdateDiaryRequest request) {
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        diary.update(request.getDiaryTitle(), request.getDiaryContent());

        return diary;
    }
}
