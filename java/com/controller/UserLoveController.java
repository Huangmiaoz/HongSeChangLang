package com.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.common.Result;
import com.entity.UserLove;
import com.service.UserLoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ……hyy……
 * @since 2022-05-21
 */
@RestController
@RequestMapping("/love")
public class UserLoveController {
    @Autowired
    UserLoveService userLoveService;

    @GetMapping("/{userId}/{articleId}")
    public Result add(@PathVariable("userId")Integer userId,
                      @PathVariable("articleId") Integer articleId){
        LambdaQueryWrapper<UserLove> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserLove::getUserId,userId);
        queryWrapper.eq(UserLove::getArticleId,articleId);
        UserLove one = userLoveService.getOne(queryWrapper);
        if(one !=  null && one.getId() != null) {
            userLoveService.removeById(one.getId());
            return Result.fail("文章收藏删除成功！");
        }
        UserLove userLove = new UserLove();
        userLove.setUserId(userId);
        userLove.setArticleId(articleId);
        userLoveService.save(userLove);
        return Result.success(null , "文章收藏新增成功！");

    }
}
