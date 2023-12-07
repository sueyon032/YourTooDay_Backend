package org.fire.dto;

import lombok.Getter;
import org.fire.domain.DiaryCover;

import java.util.List;

// 일기장의 상세정보 (일기장 내부 화면에 필요)
@Getter
public class DiaryCoverDetailResponse {
    private final String diaryCoverName;
    private final String diaryCoverImage;
    private final List<DiaryResponse> diaries; // Diary 엔티티의 정보를 포함

    public DiaryCoverDetailResponse(DiaryCover diaryCover) {
        this.diaryCoverName = diaryCover.getDiaryCoverName();
        this.diaryCoverImage = diaryCover.getDiaryCoverImage();
        this.diaries = diaryCover.getDiaries().stream().map(DiaryResponse::new).toList();
    }
}
