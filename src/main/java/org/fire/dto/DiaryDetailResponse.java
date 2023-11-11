package org.fire.dto;

import lombok.Getter;
import org.fire.domain.Diary;

// 일기의 상세정보 (일기 보기 화면)
@Getter
public class DiaryDetailResponse {

    private String diaryTitle;
    private String diaryContent;

    public DiaryDetailResponse(Diary diary) {
        this.diaryTitle = diary.getDiaryTitle();
        this.diaryContent = diary.getDiaryContent();
    }
}
