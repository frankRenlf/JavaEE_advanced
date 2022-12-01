package com.example.ademo.controller;

import com.example.ademo.controller.utils.Result;
import com.example.ademo.domain.Article;
import com.example.ademo.service.IArticleService;
import com.example.ademo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.controller
 * @createTime : 2022/12/1 20:12
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private IArticleService iArticleService;

    @GetMapping("/{id}")
    public Result retArticle(@PathVariable Integer id) {
//        log.warn("test log->debug");
        return new Result(true, iArticleService.mySelectById(id));
    }

    @GetMapping("/list")
    public Result retList() {
//        log.warn("test log->debug");
        return new Result(true, iArticleService.myList());
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Article article) {
//        log.warn("test log->debug");
        return new Result(true, iArticleService.myInsert(article));
    }

    @PostMapping("/remove/{id}")
    public Result remove(@PathVariable Integer id) {
//        log.warn("test log->debug");
        return new Result(true, iArticleService.myRemoveById(id));
    }

    @PostMapping("/update")
    public Result update(@RequestBody Article article) {
//        log.warn("test log->debug");
        return new Result(true, iArticleService.myUpdate(article));
    }
}
