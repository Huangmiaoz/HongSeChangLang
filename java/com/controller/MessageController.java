package com.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.common.Result;
import com.entity.Message;
import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
 * @since 2022-06-03
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/{articleId}")
    public Result getMessageByArticleIdAndUserID(@PathVariable("articleId")Integer articleId) {
        LambdaQueryWrapper<Message> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Message::getArticleId, articleId);
        List<Message> messageList = messageService.list(wrapper);
        return Result.success(messageList, "获取文章评论列表成功！");
    }

    @PostMapping("/create")
    public Result createMessage(@RequestBody @Valid Message message) {
        message.setCreateTime(LocalDateTime.now());
        boolean save = messageService.save(message);
        return save ? Result.success(null, "添加评论成功") : Result.fail(null,"添加评论失败");
    }
}
