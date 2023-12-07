package org.fire.dto;

import lombok.Getter;
import org.fire.domain.Diary;

// Response(응답): 서버가 클라이언트에게 요청에 대한 결과를 돌려주는 메시지
// Diary 엔티티의 데이터를 클라이언트로 전달하기 위한 데이터 전송 객체 (DTO)

@Getter
public class DiaryResponse {

    // 클라이언트가 필요로 하는 데이터만을 담고 있어 불필요한 데이터 전송을 방지하고 필요한 정보만을 포함시킬 수 있음.
    private String diaryTitle;
    private String diaryDate;

    // Diary 엔티티를 받아 DiaryResponse 객체로 변환
    // diary에서 diaryTitle과 diaryDate 필드를 읽어온 후, 해당 필드를 DiaryResponse 객체에 설정
    public DiaryResponse(Diary diary) {
        this.diaryTitle = diary.getDiaryTitle();
        this.diaryDate = diary.getDiaryDate().toString();
    }

}
