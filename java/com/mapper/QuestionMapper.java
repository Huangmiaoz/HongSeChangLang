package com.mapper;

import com.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ……hyy……
 * @since 2022-05-17
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}
