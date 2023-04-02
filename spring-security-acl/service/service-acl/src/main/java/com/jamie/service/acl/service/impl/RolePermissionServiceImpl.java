package com.jamie.service.acl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jamie.service.acl.entity.RolePermission;
import com.jamie.service.acl.mapper.RolePermissionMapper;
import com.jamie.service.acl.service.RolePermissionService;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

}
