package com.example.SpringStudy.repository;

import com.example.SpringStudy.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}

