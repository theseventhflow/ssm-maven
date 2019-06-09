package com.ssm.maven.core.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.maven.core.mapper.UserMapper;
import com.ssm.maven.core.pojo.User;
import com.ssm.maven.core.service.UserService;

/**
 * @author 1034683568@qq.com
 * @project_name ssm-maven
 * @date 2017-3-1
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public List<User> findUser(Map<String, Object> map) {
        return userMapper.findUsers(map);
    }

    @Override
    public int updateUser(User user) {
        //防止有人胡乱修改导致其他人无法正常登陆
        if ("controller".equals(user.getUserName())) {
            return 0;
        }
        return userMapper.updateUser(user);
    }

    @Override
    public Long getTotalUser(Map<String, Object> map) {
        return userMapper.getTotalUser(map);
    }

    @Override
    public int addUser(User user) {
        if (user.getUserName() == null || user.getPassword() == null || getTotalUser(null) > 90) {
            return 0;
        }
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        //防止有人胡乱修改导致其他人无法正常登陆
        if (2 == id) {
            return 0;
        }
        return userMapper.deleteUser(id);
    }

}
