package org.fire.repository;

import org.fire.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YourtoodayRepository extends JpaRepository<Article, Long> {
}
