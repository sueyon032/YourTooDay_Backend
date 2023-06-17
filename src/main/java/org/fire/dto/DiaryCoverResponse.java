package org.fire.dto;

import lombok.Getter;
import org.fire.domain.DiaryCover;

@Getter
public class DiaryCoverResponse {

    private final String diaryCoverName;
    private final String diaryCoverKeyword;
//    private final boolean diaryCoverSubscribe;

    public DiaryCoverResponse(DiaryCover diaryCover) {  // 일기장 조회
        this.diaryCoverName = diaryCover.getDiaryCoverName();
        this.diaryCoverKeyword = diaryCover.getDiaryCoverKeyword();
//        this.diaryCoverSubscribe = false;
    }
}
