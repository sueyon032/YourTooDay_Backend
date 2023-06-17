package org.fire.dto;

import lombok.Getter;
import org.fire.domain.Sympathy;

@Getter
public class SympathyResponse {

    private int sympathyKind;
    private Long userNo;
    private Long diaryNo;

    public SympathyResponse(Sympathy sympathy){
        this.sympathyKind=sympathy.getSympathyKind();
        this.userNo=sympathy.getUserNo();
        this.diaryNo=sympathy.getDiaryNo();
    }
}
