package com.example.SpringStudy.controller;

import com.example.SpringStudy.dto.ArticleForm;
import com.example.SpringStudy.entity.Article;
import com.example.SpringStudy.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
//        System.out.println(form.toString());
        log.info(form.toString());

        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
//        System.out.println(article.toString());
        log.info(article.toString());
        // 2. 리파지터리로 엔티티를 DB로 저장
        Article saved = articleRepository.save(article);
//        System.out.println(saved.toString());
        log.info(saved.toString());
        return "";
    }
}