package com.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.common.Result;
import com.entity.History;
import com.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ……hyy……
 * @since 2022-06-11
 */
@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping("list")
    public Result historyList(){
        return Result.success(historyService.list());
    }
    @GetMapping("/{userId}")
    public Result historyByUserId(@PathVariable("userId") Integer userId){
        LambdaQueryWrapper<History> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(History::getUserId, userId);
        List<History> historyList = historyService.list(queryWrapper);
        return Result.success(historyList, "获取用户答题历史成绩成功");
    }

    @PostMapping("create")
    public Result createHistory(@RequestBody @Valid History history) {
        history.setCreateTime(LocalDateTime.now());
        boolean flag = historyService.save(history);
        return  flag ? Result.success( null,"增加用户答题历史成功^_^")
                    : Result.fail(null, "增加用户答题历史失败-_-!");
    }

}
