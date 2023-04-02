package com.jamie.service.acl.controller;

import com.alibaba.fastjson.JSONObject;
import com.jamie.service.acl.service.IndexService;
import com.jamie.service.base.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/acl/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 根据 token获取用户角色、权限等信息
     */
    @GetMapping("info")
    public R info() {
        // Security 上下文获取登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> userInfo = indexService.getUserInfo(username);
        return R.ok().data(userInfo);
    }

    /**
     * 获取菜单
     */
    @GetMapping("menu")
    public R getMenu() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<JSONObject> permissionList = indexService.getMenu(username);
        return R.ok().data("permissionList", permissionList);
    }

    @PostMapping("logout")
    public R logout() {
        return R.ok();
    }

}
