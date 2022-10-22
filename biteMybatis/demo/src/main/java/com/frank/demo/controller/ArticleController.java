package com.frank.demo.controller;

import com.frank.demo.controller.utils.Result;
import com.frank.demo.domain.Article;
import com.frank.demo.presistence.Info;
import com.frank.demo.service.IArticleService;

import com.frank.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.controller
 * @createTime : 2022/10/19 18:28
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

    @GetMapping("/articlelist/{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, iArticleService.selectById2(id));
    }

    @GetMapping("/articlelist")
    public Result getAll() {
        return new Result(true, iArticleService.getAll());
    }

    @GetMapping("/articlelist/user")
    public Result getUserArticles(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Integer userid = (Integer) session.getAttribute("userid");
        return new Result(true, iArticleService.getUserArticles(userid));
    }

    @PostMapping("/add")
    public Result addArticle(@RequestBody Article article, HttpServletRequest request) {
//        Info info = new Info();
        HttpSession session = request.getSession(true);
//        Integer id = UserController.currentUser.getId() == null ?
//                (new Info()).user.getId() : UserController.currentUser.getId();
        Integer id = (Integer) session.getAttribute("userid");
        article.setUid(id);
        System.out.println("---------------------");
        System.out.println(article.getUid());
        System.out.println("---------------------");
        return new Result(true, iArticleService.save(article));
    }

    @PostMapping("/del/{createtime}")
    public Result delArticle(HttpServletRequest request, @PathVariable String createtime) {
        HttpSession session = request.getSession(true);
        iArticleService.deleteByUidAndCreatetime(createtime, (Integer) session.getAttribute("userid"));
        return new Result(true);
    }
}
