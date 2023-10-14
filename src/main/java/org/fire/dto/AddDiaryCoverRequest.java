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
    private String diaryCoverImage;
    private Long writerNo;

    public DiaryCover toEntity(){
        return DiaryCover.builder()
                .diaryCoverName(diaryCoverName)
                .diaryCoverKeyword(diaryCoverKeyword)
                .diaryCoverImage(diaryCoverImage)
                .writerNo(writerNo)
                .build();
    }
}
