package org.fire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fire.domain.Diary;

// Request(요청): 클라이언트가 서버에게 어떤 동작을 수행하거나 데이터를 보내기 위해 보내는 메시지
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddDiaryRequest {

    private String diaryTitle;
    private String diaryContent;
    private Long diaryCoverNo;

    // 생성 요청에는 새로운 엔티티를 만들기 위한 필드가 포함되며, 따라서 toEntity 메서드가 필요하다
    // 엔터티를 만들 때 필요한 모든 필드 값이 포함되어야 함.
    public Diary toEntity() {
        return Diary.builder()
                .diaryTitle(diaryTitle)
                .diaryContent(diaryContent)
                .diaryCoverNo(diaryCoverNo)
                .build();
    }
}
