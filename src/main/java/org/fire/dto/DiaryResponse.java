package org.fire.dto;

import lombok.Getter;
import org.fire.domain.Diary;

@Getter
public class DiaryResponse {

    private String diaryTitle;
    private String diaryContent;
    private String diaryDate;

    public DiaryResponse(Diary diary) {
        this.diaryTitle = diary.getDiaryTitle();
        this.diaryContent = diary.getDiaryContent();
        this.diaryDate = diary.getDiaryDate().toString();
    }

}
