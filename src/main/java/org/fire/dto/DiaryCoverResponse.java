package org.fire.dto;

import lombok.Getter;
import org.fire.domain.DiaryCover;

@Getter
public class DiaryCoverResponse {

    private final Long diaryCoverNo;
    private final String diaryCoverName;
    private final String diaryCoverKeyword;
    private final String diaryCoverImage;
    private final Long writerNo;

    public DiaryCoverResponse(DiaryCover diaryCover) {  // 일기장 조회
        this.diaryCoverNo = diaryCover.getDiaryCoverNo();
        this.diaryCoverName = diaryCover.getDiaryCoverName();
        this.diaryCoverKeyword = diaryCover.getDiaryCoverKeyword();
        this.diaryCoverImage = diaryCover.getDiaryCoverImage();
        this.writerNo = diaryCover.getWriterNo();
    }
}
