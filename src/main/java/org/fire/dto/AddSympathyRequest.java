package org.fire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fire.domain.Sympathy;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddSympathyRequest {

    private int sympathyKind;
    private long userNo;
    private long diaryNo;

    public Sympathy toEntity(){
        return Sympathy.builder()
                .sympathyKind(sympathyKind)
                .userNo(userNo)
                .diaryNo(diaryNo)
                .build();
    }
}
