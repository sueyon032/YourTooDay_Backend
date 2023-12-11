package org.fire.repository;

import org.fire.domain.DiaryCover;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiaryCoverRepository extends JpaRepository<DiaryCover, Long> {
    // findAllByWriterNo(userno)

        // 유어투데이: findAllByUserNo

    List<DiaryCover> findByWriterNoNot(Long writerNo);
    List<DiaryCover> findByDiaryCoverKeywordContainingIgnoreCase(String keyword);
}
