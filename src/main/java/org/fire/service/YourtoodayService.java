package org.fire.service;

import lombok.RequiredArgsConstructor;
import org.fire.domain.Article;
import org.fire.dto.AddArticleRequest;
import org.fire.repository.YourtoodayRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class YourtoodayService {

    private final YourtoodayRepository yourtoodayRepository;

    public Article save(AddArticleRequest request){
        return yourtoodayRepository.save(request.toEntity());
    }
}
