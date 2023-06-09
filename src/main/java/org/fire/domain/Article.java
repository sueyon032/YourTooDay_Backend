package org.fire.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_no", updatable = false)
    private Long articleNo; // 기본키


    @Column(name = "diary_name", nullable = false)
    private String diaryName; // 일기장 이름

    @Column(name = "keyword", nullable = false)
    private String keyword; // 일기장 키워드


    @Column(name = "title", nullable = false)
    private String title; // 일기 제목

    @Column(name = "content", nullable = false)
    private String content; // 일기 내용

    @Column(name = "author", nullable = false)
    private String author; // 일기 작성자

    @Column(name = "date", nullable = false)
    private String date; // 일기 작성 날짜

    @Column(name = "comment", nullable = false)
    private String comment; // 일기 댓글

    @Builder
    public Article(String diaryName, String keyword, String title, String content, String author, String date, String comment) {
        this.diaryName = diaryName;
        this.keyword = keyword;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.comment = comment;
    }
}
