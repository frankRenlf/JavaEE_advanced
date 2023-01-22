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
import java.util.Objects;

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
    public Result insert(@RequestBody Article article, HttpSession session) {
//        log.warn("test log->debug");
        article.setUid(((User) session.getAttribute(Constant.SESSION_USERINFO_KEY)).getUserId());
        Object data = iArticleService.myInsert(article);
        return Result.success(data);
    }

    @GetMapping("/pagingList/{pageIndex}/{pageSize}")
    public Result pagingList(@PathVariable Integer pageIndex, @PathVariable Integer pageSize) {
//        log.warn("test log->debug");
        Integer start = pageSize * (pageIndex - 1);
        return Result.success("pagingList");
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
    public Result getArticleById(@PathVariable Integer id) {
//        log.warn("test log->debug");
        iArticleService.addRcount(id, iArticleService.mySelectById(id).getRcount());
        return Result.success(iArticleService.mySelectById(id));
    }

    @GetMapping("/user/{aid}")
    public Result getUserInfo(@PathVariable Integer aid) {
//        log.warn("test log->debug");
        Integer uid = iArticleService.mySelectById(aid).getUid();
        User user = iUserService.mySelectById(uid);
        user.setArticleNumber(iArticleService.countByUserId(uid));
        user.setPassword(null);
        return Result.success(user);
    }

    @GetMapping("/list/{order}")
    public Result listAll(@PathVariable String order) {
//        log.warn("test log->debug");
        return Result.success(iArticleService.listAll(order));
    }

    @GetMapping("/myList/{order}")
    public Result myList(@PathVariable String order, HttpSession session) {
//        log.warn("test log->debug");
        Integer uid = ((User) session.getAttribute(Constant.SESSION_USERINFO_KEY)).getUserId();
        return Result.success(iArticleService.myList(order, uid));
    }

    @GetMapping("/countByUserId")
    public Result countByUserId(HttpSession session) {
//        log.warn("test log->debug");
        Integer uid = ((User) session.getAttribute(Constant.SESSION_USERINFO_KEY)).getUserId();
        User user = iUserService.mySelectById(uid);
        user.setArticleNumber(iArticleService.countByUserId(uid));
        user.setPassword(null);
        return Result.success(user);
    }

    @GetMapping("/remove/{id}")
    public Result remove(@PathVariable Integer id) {
//        log.warn("test log->debug");
        return Result.success(iArticleService.myRemoveById(id));
    }

    @PostMapping("/update")
    public Result update(@RequestBody Article article, HttpSession session) {
//        log.warn("test log->debug");
        Integer uid = ((User) session.getAttribute(Constant.SESSION_USERINFO_KEY)).getUserId();
        if (Objects.equals(uid, article.getUid())) {
            return Result.success(iArticleService.myUpdate(article));
        }
        return Result.fail(iArticleService.myUpdate(article));
    }

}
