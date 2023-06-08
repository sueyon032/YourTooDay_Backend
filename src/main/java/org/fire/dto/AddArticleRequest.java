package org.fire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fire.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;
    private String author;
    private String date;

    public Article toEntity(){
        return Article.builder()
                .title(title)
                .content(content)
                .author(author)
                .date(date)
                .build();
    }

}
