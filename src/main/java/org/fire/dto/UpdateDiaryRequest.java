package org.fire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 업데이트 요청은 일부 필드만 업데이트하는 데 사용되며, 모든 필드를 포함하지 않을 수 있음.
// 따라서 UpdateDiaryRequest 클래스에 toEntity 메서드를 추가하는 것은 일반적으로 필요하지 않다.
// 대신, 업데이트 메서드(예: update 메서드)를 서비스 클래스에서 사용하여 엔터티를 업데이트함.
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateDiaryRequest {

    private String diaryTitle;
    private String diaryContent;
    private String diarySympathy;
    private String diaryComment;

}
