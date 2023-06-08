package org.fire.controller;

import lombok.RequiredArgsConstructor;
import org.fire.domain.Article;
import org.fire.dto.AddArticleRequest;
import org.fire.service.YourtoodayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class YourtoodayApiController {

    private final YourtoodayService yourtoodayService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle= yourtoodayService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

}
