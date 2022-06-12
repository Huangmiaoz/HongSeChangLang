package com.mapper;

import com.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ……hyy……
 * @since 2022-05-21
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
