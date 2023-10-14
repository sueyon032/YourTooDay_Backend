package org.fire.dto;

import lombok.Getter;
import org.fire.domain.Diary;

@Getter
public class DiaryResponse {

    private String diaryTitle;
    private String diaryDate;

    public DiaryResponse(Diary diary) {
        this.diaryTitle = diary.getDiaryTitle();
        this.diaryDate = diary.getDiaryDate().toString();
    }

}
