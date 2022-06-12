package com.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ……hyy……
 * @since 2022-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_thing")
public class Thing implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "thing_id", type = IdType.AUTO)
    private Integer thingId;

    private String thingName;

    private String thingTime;

    private String tingDescription;


}
