package org.fire.repository;

import org.fire.domain.Sympathy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SympathyRepository extends JpaRepository<Sympathy, Long> {

    // Sympathy 엔티티에서 diaryNo 필드에 해당하는 값을 기준으로 조회하는 메서드
    // 특정 diaryNo에 대한 모든 공감 (sympathy) 항목을 찾을 수 있음
    List<Sympathy> findAllByDiaryNo(Long diaryNo);
}
