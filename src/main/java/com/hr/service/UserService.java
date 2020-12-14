package com.hr.service;

import com.hr.mapper.UserMapper;
import com.hr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public void saveUser(User user) {
        //选择性新增,如果属性为空则该属性不会出现在insert语句上
        userMapper.insertSelective(user);
        //事务回滚
        int i = 1/ 0;
    }
}
