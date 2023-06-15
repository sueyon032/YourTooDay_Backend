package org.fire.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class DiaryCover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_cover_no", updatable = false)
    private Long diaryCoverNo; // 기본키


    @Column(name = "diary_name", nullable = false)
    private String diaryCoverName; // 일기장 이름

    @Column(name = "diary_keyword", nullable = false)
    private String diaryCoverKeyword; // 일기장 키워드

    @Column(name = "diary_subscribe", nullable = false)
    private boolean diaryCoverSubscribe; // 일기장 구독

    @Builder
    public DiaryCover(String diaryCoverName, String diaryCoverKeyword, boolean diaryCoverSubscribe) {
        this.diaryCoverName = diaryCoverName;
        this.diaryCoverKeyword = diaryCoverKeyword;
        this.diaryCoverSubscribe=diaryCoverSubscribe;
    }
}
