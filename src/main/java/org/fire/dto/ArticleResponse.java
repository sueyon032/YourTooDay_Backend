package org.fire.dto;

import lombok.Getter;
import org.fire.domain.Article;

@Getter
public class ArticleResponse {
    private final String diaryName;
    private final String keyword;
    private final String title;
    private final String content;
    private final String author;
    private final String date;
    private final String comment;

    public ArticleResponse(Article article) {
        this.diaryName = article.getDiaryName();
        this.keyword = article.getKeyword();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.author = article.getAuthor();
        this.date = article.getDate();
        this.comment = article.getComment();
    }
}
