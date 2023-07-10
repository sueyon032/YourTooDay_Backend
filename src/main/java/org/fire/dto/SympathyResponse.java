package org.fire.dto;

import lombok.Getter;
import org.fire.domain.Diary;
import org.fire.domain.Sympathy;
import org.fire.domain.User;

@Getter
public class SympathyResponse {

    private int sympathyKind;
    private User userNo;
    private Diary diaryNo;

    public SympathyResponse(Sympathy sympathy){
        this.sympathyKind=sympathy.getSympathyKind();
        this.userNo=sympathy.getUserNo();
        this.diaryNo=sympathy.getDiaryNo();
    }
}
