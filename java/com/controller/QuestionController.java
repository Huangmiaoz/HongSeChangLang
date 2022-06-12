package com.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.common.Result;
import com.entity.Question;
import com.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public Result getAll(){
        return Result.success(questionService.list());
    }

    @PostMapping("/create")
    public Result save(@RequestBody Question question) throws IOException {
        boolean flag = questionService.save(question);
        return  flag ? Result.success( null,"添加成功^_^") : Result.fail("添加失败-_-!");

    }

    @PutMapping("/update")
    public Result update(@RequestBody Question question) throws IOException {
        boolean flag = questionService.update(question);
        return  flag? Result.success( null,"修改成功^_^") : Result.fail(null, "修改失败-_-!");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.success(questionService.delete(id));
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return Result.success(questionService.getById(id));
    }

    /**
     *
     * @param currentPage
     * @param pageSize
     * @return 答题后台管理界面，分页获取问题列表
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        System.out.println("====>"+question);
        IPage<Question> page = questionService.getPage(currentPage, pageSize);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = questionService.getPage((int)page.getPages(), pageSize);
        }
        return  Result.success(page, "分页获取文章列表成功");
    }

    @GetMapping("/like")
    public  Result likeSearch(String like){
        return Result.success(questionService.like(like), "模糊查询文章成功");
    }

    @PostMapping("/history")
    public Result history(){

        return  Result.success(null, "获取答题历史记录成功");
    }




}

















