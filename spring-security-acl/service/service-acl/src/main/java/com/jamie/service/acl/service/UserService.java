package com.jamie.service.acl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jamie.service.acl.entity.User;

public interface UserService extends IService<User> {
    User selectByUsername(String username);
}
