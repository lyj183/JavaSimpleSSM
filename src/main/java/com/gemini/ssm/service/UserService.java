package com.gemini.ssm.service;

import com.gemini.ssm.model.User;

/**
 * @author: linyijin
 * @Date: Created in 2018/2/6 10:37
 * @Description:
 **/
public interface UserService {
    // 查
    public User getUserByID(int id);

    /**
     * 以下内容均为自己练习添加
     */
    // 增
    public User addUser(int id, String name, String pin, int age);
    // 删
    public String removeUser(int id);
    // 改
    public String updateUser(User user);

}
