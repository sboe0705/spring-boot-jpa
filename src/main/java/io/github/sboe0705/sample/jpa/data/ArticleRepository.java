package io.github.sboe0705.sample.jpa.data;

import io.github.sboe0705.sample.jpa.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
}
