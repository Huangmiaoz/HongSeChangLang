package com.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ……hyy……
 * @since 2022-05-25
 */
public interface UserService extends IService<User> {
    boolean save(User user);
    boolean delete(Integer id);
    boolean update(User user);
    User getById(Integer id);
    List<User> getAll();
    IPage<User> getPage(int currentPage, int PageSize);

    Boolean Login(User user);
}
