package org.fire.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary_cover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_cover_no", updatable = false)
    private Long diary_cover_No; // 기본키

    @Column(name = "title", nullable = false)
    private String title; // 일기 제목

    @Column(name = "content", nullable = false)
    private String content; // 일기 내용

    @Column(name = "sympathy ", nullable = false)
    private String sympathy ; // 일기 작성 날짜

    @Column(name = "date", nullable = false)
    private String date; // 일기 작성 날짜

    @Column(name = "comment", nullable = false)
    private String comment; // 일기 댓글

    @Builder
    public Diary_cover(String title, String content, String sympathy, String date, String comment) {
        this.title = title;
        this.content = content;
        this.sympathy=sympathy;
        this.date = date;
        this.comment = comment;
    }
}
