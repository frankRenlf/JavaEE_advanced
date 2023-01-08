package com.example.ademo.controller;

import com.example.ademo.controller.utils.Result;
import com.example.ademo.domain.Article;
import com.example.ademo.service.IArticleService;
import com.example.ademo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired(required = false)
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired(required = false)
    private TransactionDefinition transactionDefinition;

    @PostMapping("/insert")
    public Result insert(@RequestBody Article article) {
//        log.warn("test log->debug");
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        Object data = iArticleService.myInsert(article);
        dataSourceTransactionManager.rollback(transactionStatus);
        return new Result(true, data);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @PostMapping("/insert2")
    public Result insert2(@RequestBody Article article) {
//        log.warn("test log->debug");
        Object data = iArticleService.myInsert(article);

        int x = 10 / 0;

        return new Result(true, data);
    }

    @GetMapping("/{id}")
    public Result retArticle(@PathVariable Integer id) {
//        log.warn("test log->debug");
        return new Result(true, iArticleService.mySelectById(id));
    }

    @GetMapping("/list/{order}")
    public Result retList(@PathVariable String order) {
//        log.warn("test log->debug");
        return new Result(true, iArticleService.myList(order));
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
