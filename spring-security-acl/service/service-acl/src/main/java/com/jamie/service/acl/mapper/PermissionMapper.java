package com.jamie.service.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jamie.service.acl.entity.Permission;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {
    List<String> selectPermissionValueByUserId(String id);

    List<String> selectAllPermissionValue();

    List<Permission> selectPermissionByUserId(String userId);
}
