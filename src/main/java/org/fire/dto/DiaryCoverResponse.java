package org.fire.dto;

import lombok.Getter;
import org.fire.domain.DiaryCover;

@Getter
public class DiaryCoverResponse {

//<<<<<<< feature/diary-cover
//=======
    private final Long diaryCoverNo;
//>>>>>>> main
    private final String diaryCoverName;
    private final String diaryCoverKeyword;
    private final String diaryCoverImage;
    private final Long writerNo;

//<<<<<<< feature/diary-cover

    public DiaryCoverResponse(DiaryCover diaryCover) {  // 일기장 조회
//=======
    public DiaryCoverResponse(DiaryCover diaryCover) {  // 일기장 조회
        this.diaryCoverNo = diaryCover.getDiaryCoverNo();
//>>>>>>> main
        this.diaryCoverName = diaryCover.getDiaryCoverName();
        this.diaryCoverKeyword = diaryCover.getDiaryCoverKeyword();
        this.diaryCoverImage = diaryCover.getDiaryCoverImage();
        this.writerNo = diaryCover.getWriterNo();
    }
}
