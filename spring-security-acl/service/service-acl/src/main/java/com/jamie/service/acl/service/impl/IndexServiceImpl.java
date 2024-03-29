package com.jamie.service.acl.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.jamie.service.acl.entity.Role;
import com.jamie.service.acl.entity.User;
import com.jamie.service.acl.service.IndexService;
import com.jamie.service.acl.service.PermissionService;
import com.jamie.service.acl.service.RoleService;
import com.jamie.service.acl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据用户名获取用户登录信息
     */
    public Map<String, Object> getUserInfo(String username) {
        Map<String, Object> result = new HashMap<>();
        User user = userService.selectByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("user not found in database");
        }

        // 根据用户id获取角色
        List<Role> roleList = roleService.selectRoleByUserId(user.getId());
        List<String> roleNameList = roleList.stream().map(Role::getRoleName).collect(Collectors.toList());
        if(roleNameList.size() == 0) {
            roleNameList.add("");
        }

        // 根据用户id获取权限
        List<String> permissionValueList = permissionService.selectPermissionValueByUserId(user.getId());
        redisTemplate.opsForValue().set(username, permissionValueList);

        result.put("name", user.getUsername());
        result.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        result.put("roles", roleNameList);
        result.put("permissionValueList", permissionValueList);
        return result;
    }

    /**
     * 根据用户名获取动态菜单
     */
    public List<JSONObject> getMenu(String username) {
        User user = userService.selectByUsername(username);
        //根据用户id获取用户菜单权限
        return permissionService.selectPermissionByUserId(user.getId());
    }

}
