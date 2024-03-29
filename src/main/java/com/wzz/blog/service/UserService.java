package com.wzz.blog.service;

import com.wzz.blog.pojo.User;

/**
 * @author wzzap
 * @date 2019/6/22
 **/
public interface UserService {
    /**
     * 检测输入的用户名和密码是否存在
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User checkUser(String username, String password);
}
