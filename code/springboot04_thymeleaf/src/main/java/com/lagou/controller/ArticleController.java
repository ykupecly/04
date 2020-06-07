package com.lagou.controller;


import com.lagou.pojo.Article;
import com.lagou.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/index")
    public ModelAndView index(@RequestParam(value = "start", defaultValue = "0") Integer start,
                              @RequestParam(value = "limit", defaultValue = "1") Integer limit) {
        start = start < 0 ? 0 : start;

        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(start, limit, sort);
        Page<Article> page = articleService.findAll(pageable);

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("page", page);
        return mav;
    }
}
