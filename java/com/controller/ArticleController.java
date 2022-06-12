package com.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.Result;
import com.entity.Article;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ……hyy……
 * @since 2022-05-21
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/{id}")
    public Result getArticleById(@PathVariable("id")Integer id) {
        Article article = articleService.getById(id);
        article.setArticleViewCount(article.getArticleViewCount() + 1);
        //增加浏览次数，重写回数据库
        articleService.updateById(article);
        return Result.success(article);
    }
    @GetMapping("/{page}/{pageSize}")
    public Result getArticlePage(@PathVariable("page")Integer page,@PathVariable("pageSize") Integer pageSize) {
        Page<Article> page1 = new Page<>(page, pageSize);
        Page<Article> articlePage = articleService.page(page1);
        return Result.success(articlePage);
    }

    @PostMapping("/create")
    public Result createArticle(@RequestBody @Valid Article article) throws Exception{
        return articleService.save(article) ?
                Result.success(null , "文章新增成功！") :
                Result.fail("文章新增失败！");
    }

    @PostMapping("/update")
    public Result updateArticle(@RequestBody @Valid Article article) throws Exception{
        return articleService.updateById(article) ?
                Result.success(null , "文章修改成功！") :
                Result.fail("文章修改失败！");
    }

    @DeleteMapping("/{id}")
    public Result deleteArticleById(@PathVariable("id")Integer id) {
        return articleService.removeById(id) ?
                Result.success(null,"删除文章成功") : Result.fail("删除文章失败");
    }
}
