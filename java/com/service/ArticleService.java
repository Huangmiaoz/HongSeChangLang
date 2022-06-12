package com.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ……hyy……
 * @since 2022-05-21
 */
public interface ArticleService extends IService<Article> {
    boolean save(Article article);
    boolean delete(Integer id);
    boolean update(Article article);
    Article getById(Integer id);
    List<Article> getAll();
    IPage<Article> getPage(int currentPage, int PageSize);

}
