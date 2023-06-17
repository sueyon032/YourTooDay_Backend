package org.fire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateDiaryRequest {

    private String diaryTitle;
    private String diaryContent;
    private String diarySympathy;
    private String diaryComment;

}
