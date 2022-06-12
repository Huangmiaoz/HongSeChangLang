package com.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ……hyy……
 * @since 2022-05-17
 */
public interface QuestionService extends IService<Question> {
    boolean save(Question question);
    boolean delete(Integer id);
    boolean update(Question question);
    Question getById(Integer id);
    List<Question> getAll();
    IPage<Question> getPage(int currentPage,int PageSize);

    List<Question> like(String title);
}
