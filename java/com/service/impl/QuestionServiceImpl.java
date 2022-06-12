package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Question;
import com.mapper.QuestionMapper;
import com.service.QuestionService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ……hyy……
 * @since 2022-05-17
 */
@Service
//定义成业务层对应的bean
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public boolean save(Question question) {
//        返回影响行数
        return questionMapper.insert(question) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return questionMapper.deleteById(id) > 0;
    }

    @Override
    public boolean update(Question question) {
        return questionMapper.updateById(question) > 0;
    }

    @Override
    public Question getById(Integer id) {
        return questionMapper.selectById(id);
    }

    @Override
    public List<Question> getAll() {
        return questionMapper.selectList(null);
    }

    @Override
    public IPage<Question> getPage(int currentPage,int pageSize) {
        Page page = new Page(currentPage,pageSize);
        return questionMapper.selectPage(page,null);
    }

    @Override
    public List<Question> like(String title) {
        LambdaQueryWrapper<Question> wrapper = Wrappers.lambdaQuery();
        wrapper.like(Objects.nonNull(title),Question::getTitle,title);
        return this.list(wrapper);
    }


}
