package com.first.blog.repository.impl;

import com.first.blog.domain.User;
import com.first.blog.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 *  UserRepositoryImpl 实现类
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static AtomicLong counter = new AtomicLong();//这个类是用来计数的  每次增加一个  就递增一个，这样每个用户都会有一个唯一的id
    private final ConcurrentMap<Long,User>userMap = new ConcurrentHashMap<>();

    /**
     * 创建或者修改用户
     *
     * @param user
     * @return
     */
    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if (null == id){    //新建
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id,user);
        return user;
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(Long id) {
        return this.userMap.get(id);
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    @Override
    public List<User> listUser(){
        return new ArrayList<User>(this.userMap.values());
    }
}
