package org.fire.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "diary_sympathy ", nullable = false)
    private String diarySympathy; // 일기 작성 날짜

    @Column(name = "diary_date", nullable = false)
    private String diaryDate; // 일기 작성 날짜

    @Column(name = "diary_comment", nullable = false)
    private String diaryComment; // 일기 댓글

    @Builder
    public Diary(String diaryTitle, String diaryContent, String diarySympathy, String diaryDate, String diaryComment) {
        this.diaryTitle = diaryTitle;
        this.diaryContent = diaryContent;
        this.diarySympathy=diarySympathy;
        this.diaryDate = diaryDate;
        this.diaryComment = diaryComment;
    }
}
