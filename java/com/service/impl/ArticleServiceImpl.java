package com.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.Article;
import com.entity.Question;
import com.mapper.ArticleMapper;
import com.mapper.QuestionMapper;
import com.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ……hyy……
 * @since 2022-05-21
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public boolean save(Article article) {
//        返回影响行数
        return articleMapper.insert(article) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return articleMapper.deleteById(id) > 0;
    }

    @Override
    public boolean update(Article article) {
        return articleMapper.updateById(article) > 0;
    }

    @Override
    public Article getById(Integer id) {
        return articleMapper.selectById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleMapper.selectList(null);
    }

    @Override
    public IPage<Article> getPage(int currentPage, int pageSize) {
        Page page = new Page(currentPage,pageSize);
        return articleMapper.selectPage(page,null);
    }
}
