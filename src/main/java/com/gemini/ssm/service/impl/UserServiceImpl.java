package com.gemini.ssm.service.impl;

import com.gemini.ssm.dao.UserMapper;
import com.gemini.ssm.model.User;
import com.gemini.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: linyijin
 * @Date: Created in 2018/2/6 10:40
 * @Description:
 **/

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    // 查
    @Override
    public User getUserByID(int id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    /**
     * 以下内容均为自己练习添加
     */
    // 增
    @Override
    public User addUser(int id, String name, String pin, int age) {
        User user = new User();
        user.setId(id);
        user.setUserName(name);
        user.setPassword(pin);
        user.setAge(age);
        this.userMapper.insert(user);
        return this.userMapper.selectByPrimaryKey(id);
    }
    // 删
    @Override
    public String removeUser(int id) {
        this.userMapper.deleteByPrimaryKey(id);
        String string = "成功删除User！";
        return string;
    }
    // 改
    @Override
    public String updateUser(User user) {
        this.userMapper.updateByPrimaryKeySelective(user);
        String string = "成功更新User！";
        return string;
    }

}
