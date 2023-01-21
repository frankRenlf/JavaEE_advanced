package com.frank.new_blog.controller;

import com.frank.new_blog.domain.User;
import com.frank.new_blog.service.IUserService;
import com.frank.new_blog.utils.Constant;
import com.frank.new_blog.utils.Result;
import com.frank.new_blog.domain.Article;
import com.frank.new_blog.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
    @Autowired
    private IUserService iUserService;
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
    public Result listAll(@PathVariable String order) {
//        log.warn("test log->debug");
        return Result.success(iArticleService.listAll(order));
    }

    @GetMapping("/myList/{order}")
    public Result myList(@PathVariable String order, HttpSession session) {
//        log.warn("test log->debug");
        Integer uid = (Integer) session.getAttribute(Constant.SESSION_USERID_KEY);
        return Result.success(iArticleService.myList(order, uid));
    }

    @GetMapping("/countByUserId")
    public Result countByUserId(HttpSession session) {
//        log.warn("test log->debug");
        Integer uid = (Integer) session.getAttribute(Constant.SESSION_USERID_KEY);
        User user = iUserService.mySelectById(uid);
        user.setArticleNumber(iArticleService.countByUserId(uid));
        user.setPassword(null);
        return Result.success(user);
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
