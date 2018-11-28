package com.first.blog.repository;

import com.first.blog.domain.User;

import java.util.List;

/**
 *  UserRepository 接口
 */
public interface UserRepository {

    /**
     * 创建或者修改用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 查询用户列表
     * @return
     */
    List<User> listUser();

}
