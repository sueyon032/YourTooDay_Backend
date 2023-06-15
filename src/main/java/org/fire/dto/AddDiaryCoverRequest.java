package org.fire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fire.domain.DiaryCover;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddDiaryCoverRequest {

    private String diaryCoverName;
    private String diaryCoverKeyword;
    private boolean diaryCoverSubscribe;

    public DiaryCover toEntity(){
        return DiaryCover.builder()
                .diaryCoverName(diaryCoverName)
                .diaryCoverKeyword(diaryCoverKeyword)
                .diaryCoverSubscribe(diaryCoverSubscribe)
                .build();
    }
}
