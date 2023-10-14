package org.fire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateDiaryCoverRequest {
    private String diaryCoverName;
    private String diaryCoverKeyword;
    private String diaryCoverImage;
}
