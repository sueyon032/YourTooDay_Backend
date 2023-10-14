package org.fire.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryCover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_cover_no", updatable = false)
    private Long diaryCoverNo; // 기본키


    @Column(name = "diary_name", nullable = false)
    private String diaryCoverName; // 일기장 이름

    @Column(name = "diary_keyword", nullable = false)
    private String diaryCoverKeyword; // 일기장 키워드

    @Column(name = "diary_cover_image", nullable = false)
    private String diaryCoverImage; // 일기장 커버 이미지

    @Column(name = "writer_no", nullable = false)
    private Long writerNo; // 일기장 작성자 (만든 사람)

    @Builder
    public DiaryCover(String diaryCoverName, String diaryCoverKeyword, boolean diaryCoverSubscribe, String diaryCoverImage, Long writerNo) {
        this.diaryCoverName = diaryCoverName;
        this.diaryCoverKeyword = diaryCoverKeyword;
        this.diaryCoverImage = diaryCoverImage;
        this.writerNo = writerNo;
    }

    public void update(String diaryCoverName, String diaryCoverKeyword, String diaryCoverImage) {
        this.diaryCoverName = diaryCoverName;
        this.diaryCoverKeyword = diaryCoverKeyword;
        this.diaryCoverImage = diaryCoverImage;
    }
}
