package com.example.SpringStudy.service;

import com.example.SpringStudy.dto.ArticleForm;
import com.example.SpringStudy.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        Article a= new Article(1L, "가가가", "111");
        Article b= new Article(2L, "나나나", "222");
        Article c= new Article(3L, "다다다", "333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));

        List<Article> articles = articleService.index();

        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공_존재하는_id_입력() {
        // 1. 예상데이터
        Long id = 1L;
        Article expected = new Article(id, "가가가", "111");
        // 2. 실제데이터
        Article article = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void show_실패() {
        // 1. 예상데이터
        Long id = -1L;
        Article expected = null;
        // 2. 실제데이터
        Article article = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_성공_title과_content만_있는_dto입력() {
        // 1. 예상데이터
        String title = "라라라";
        String content = "444";
        ArticleForm dto = new ArticleForm(null,title, content);
        Article expected  = new Article(4L, title, content);
        // 2. 실제 데이터
        Article article = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expected.toString(),article.toString());
    }
    @Test
    void create_실패_id가_포함된_dto_입력() {
        // 1. 예상데이터
        Long id = 4L;
        String title = "라라라";
        String content = "444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expected, article);
    }
}