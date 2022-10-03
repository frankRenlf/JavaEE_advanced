package com.frank.biteclass1.Controller;

import com.frank.biteclass1.Controller.utils.Result;
import com.frank.biteclass1.domain.Article;
import com.frank.biteclass1.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.biteclass1.Controller
 * @createTime : 2022/10/3 14:14
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

    @GetMapping("{id}")
    public Result getByUserId(@PathVariable Integer id) {
        return new Result(true, iArticleService.getById(id));
    }

    @PostMapping("/update")
    public Result insert(@RequestPart("article") Article article, @RequestPart("file") MultipartFile file) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(formatter.format(date));

        byte[] finalBytes = null;
        try {
//            file = new FileInputStream("C:\\Users\\11195\\IdeaProjects\\JavaEE_advanced\\biteClass1\\src\\main\\java\\com\\frank\\biteclass1\\logs\\spring.log");
            InputStream file_pro = file.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int temp;
            while ((temp = file_pro.read(bytes)) != -1) {
                outputStream.write(bytes, 0, temp);
            }
            finalBytes = outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(true, iArticleService.save(new Article(article.getId(), article.getTitle(), article.getPublish_time(), finalBytes, article.getUser_id())));
    }


}
