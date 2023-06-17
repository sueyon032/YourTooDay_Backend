package org.fire.dto;

import lombok.Getter;
import org.fire.domain.Diary;

@Getter
public class DiaryResponse {

    private String diaryTitle;
    private String diaryContent;
    private String diarySympathy;
    private String diaryDate;
    private String diaryComment;

    public DiaryResponse(Diary diary) {
        this.diaryTitle = diary.getDiaryTitle();
        this.diaryContent = diary.getDiaryContent();
        this.diarySympathy = diary.getDiarySympathy();
        this.diaryDate = diary.getDiaryDate();
        this.diaryComment = diary.getDiaryComment();
    }

}
