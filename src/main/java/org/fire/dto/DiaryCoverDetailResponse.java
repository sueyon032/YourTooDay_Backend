package org.fire.dto;

import lombok.Getter;
import org.fire.domain.DiaryCover;

import java.util.List;

@Getter
public class DiaryCoverDetailResponse {
    private final String diaryCoverName;
    private final String diaryCoverImage;
    private final List<DiaryResponse> diaries;

    public DiaryCoverDetailResponse(DiaryCover diaryCover) {
        this.diaryCoverName = diaryCover.getDiaryCoverName();
        this.diaryCoverImage = diaryCover.getDiaryCoverImage();
        this.diaries = diaryCover.getDiaries().stream().map(DiaryResponse::new).toList();
    }
}
