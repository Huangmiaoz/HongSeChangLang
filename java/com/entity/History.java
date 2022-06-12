package com.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author ……hyy……
 * @since 2022-06-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_history")
public class History implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 答题游戏历史id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @NotNull(message = "添加用户答题游戏历史记录时，用户id不为空")
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 游戏得分
     */
    @NotNull(message = "添加用户答题游戏历史记录时，分数不为空")
    @TableField("game_score")
    private Integer gameScore;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT) //创建时自动填充
    private LocalDateTime createTime;


}
