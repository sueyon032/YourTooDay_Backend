package org.fire.service;

import lombok.RequiredArgsConstructor;
import org.fire.domain.Article;
import org.fire.dto.AddArticleRequest;
import org.fire.repository.YourtoodayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class YourtoodayService {

    private final YourtoodayRepository yourtoodayRepository;

    public Article save(AddArticleRequest request){
        return yourtoodayRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return yourtoodayRepository.findAll();
    }

    public Article findById(long id) {
        return yourtoodayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id){
        yourtoodayRepository.deleteById(id);
    }
}
