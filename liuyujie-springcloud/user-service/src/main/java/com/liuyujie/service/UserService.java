package com.liuyujie.service;

import com.liuyujie.mapper.UserMapper;
import com.liuyujie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyishou
 * @date 2020/6/15
 */
@Service
public class UserService  {

    @Autowired
    private UserMapper userMapper;

    public User qureyById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
