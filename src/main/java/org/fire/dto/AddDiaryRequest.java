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
    private Long diaryCoverNo;

    public Diary toEntity() {
        return Diary.builder()
                .diaryTitle(diaryTitle)
                .diaryContent(diaryContent)
                .diaryCoverNo(diaryCoverNo)
                .build();
    }
}
