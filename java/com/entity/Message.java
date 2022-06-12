package com.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author ……hyy……
 * @since 2022-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @TableId(value = "msg_id", type = IdType.AUTO)
    private Integer msgId;

    /**
     * 文章id
     */
    @NotNull
    private Integer articleId;

    /**
     * 用户id
     */
    @NotNull
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 评论内容
     */
    @NotNull(message = "评论内容不能为空")
    @NotEmpty(message = "评论内容不能为空")
    private String content;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT) //创建时自动填充
    private LocalDateTime createTime;


}
