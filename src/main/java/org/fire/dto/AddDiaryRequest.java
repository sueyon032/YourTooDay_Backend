package org.fire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fire.domain.Diary;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddDiaryRequest {

    private String diaryTitle;
    private String diaryContent;
    private String diarySympathy;
    private String diaryDate;
    private String diaryComment;

    public Diary toEntity() {
        return Diary.builder()
                .diaryTitle(diaryTitle)
                .diaryContent(diaryContent)
                .diarySympathy(diarySympathy)
                .diaryDate(diaryDate)
                .diaryComment(diaryComment)
                .build();
    }
}
