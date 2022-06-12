package com.controller;


import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.common.Result;
import com.entity.User;
import com.google.gson.Gson;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ……hyy……
 * @since 2022-05-25
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping("/{id}")
    @ResponseBody
    public Result getUserById(@PathVariable Integer id){
        return Result.success(userService.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    @ResponseBody
    public Result getUserPage(@PathVariable("currentPage") int currentPage,
                          @PathVariable("pageSize") int pageSize){
//        System.out.println("====>"+question);
        IPage<User> page = userService.getPage(currentPage, pageSize);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = userService.getPage((int)page.getPages(), pageSize);
        }
        return  Result.success(page);
    }

    @GetMapping("/list")
    @ResponseBody
    public Result getAllUser(){
        return Result.success(userService.list());
    }


    @PostMapping("/create")
    @ResponseBody
    public Result saveUser(@RequestBody @Validated User user) throws IOException {
        System.out.println("create user :" + user.toString());
        boolean flag = userService.save(user);
        return  flag ? Result.success( null,"注册成功^_^") : Result.fail(null,"注册失败-_-!用户名重复");
    }

    @PutMapping("/update")
    @ResponseBody
    public Result updateUser(@RequestBody @Valid User user) throws IOException {
        System.out.println(user.toString());
        boolean flag = userService.update(user);
        return  flag? Result.success( null,"修改成功^_^") : Result.fail(null, "修改失败-_-!");
    }

//    @PutMapping("/score")
//    @ResponseBody
//    public Result updateUserScore(@RequestBody @Valid User user) throws IOException {
//        System.out.println(user.toString());
//        boolean flag = userService.update(user);
//        return  flag? Result.success( null,"修改成功^_^")
//                : Result.fail(null, "修改失败-_-!");
//    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result deleteUser(@PathVariable Integer id) {
        return Result.success(userService.delete(id));
    }

    @PostMapping("/login")
    @ResponseBody
    public Result LoginUser(@RequestBody @Validated User user, Model model,
                            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean flag = userService.Login(user);
        if(!flag) {
            return Result.fail(null,"登录失败-_-!");
        }
//        model.addAttribute("user",new Gson().toJson(user));
        user.setUserPassword("");
//        request.setAttribute("user", new Gson().toJson(user));
//        request.setAttribute("username", user.getUserName());
//        request.setAttribute("userId",user.getUserId());
//        request.getRequestDispatcher("index.html").forward(request,response);
        return  Result.success(user,"登陆成功^_^");
    }
}
