package org.fire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fire.domain.Diary;
import org.fire.domain.Sympathy;
import org.fire.domain.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddSympathyRequest {

    private int sympathyKind;
    private User userNo;
    private Diary diaryNo;

    public Sympathy toEntity(){
        return Sympathy.builder()
                .sympathyKind(sympathyKind)
                .userNo(userNo)
                .diaryNo(diaryNo)
                .build();
    }
}
