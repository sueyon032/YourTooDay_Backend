package org.fire.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_no", updatable = false)
    private Long diaryNo; // 기본키

    @Column(name = "diary_title", nullable = false)
    private String diaryTitle; // 일기 제목

    @Column(name = "diary_content", nullable = false)
    private String diaryContent; // 일기 내용

    @Column(name = "diary_date", nullable = false)
    private LocalDate diaryDate = LocalDate.now(); // 일기 작성 날짜

    // (diarycover와 diary의 일대다 관계를 위한) diaryCoverNo 필드 추가
    @Column(name = "diary_cover_no", nullable = false)
    private Long diaryCoverNo;

    @Builder
    public Diary(String diaryTitle, String diaryContent, Long diaryCoverNo) {
        this.diaryTitle = diaryTitle;
        this.diaryContent = diaryContent;
        this.diaryCoverNo = diaryCoverNo;
    }

    public void update(String diaryTitle, String diaryContent) {
        this.diaryTitle = diaryTitle;
        this.diaryContent =  diaryContent;
    }
}
