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
    private Long diary_No; // 기본키


    @Column(name = "diaryname", nullable = false)
    private String diaryname; // 일기장 이름

    @Column(name = "keyword", nullable = false)
    private String keyword; // 일기장 키워드

    @Column(name = "subscribe", nullable = false)
    private String subscribe; // 일기장 키워드

    @Builder
    public Diary(String diaryname, String keyword, String subscribe) {
        this.diaryname = diaryname;
        this.keyword = keyword;
        this.subscribe=subscribe;
    }
}
