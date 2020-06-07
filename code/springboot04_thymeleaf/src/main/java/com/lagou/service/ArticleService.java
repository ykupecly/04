package com.lagou.service;

import com.lagou.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {
    Page<Article> findAll(Pageable pageable);
}
