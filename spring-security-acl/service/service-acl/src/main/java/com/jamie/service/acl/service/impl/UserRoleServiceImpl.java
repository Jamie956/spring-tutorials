package com.jamie.service.acl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jamie.service.acl.entity.UserRole;
import com.jamie.service.acl.mapper.UserRoleMapper;
import com.jamie.service.acl.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
