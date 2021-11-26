package com.cat.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class CustomRequestWrapper extends HttpServletRequestWrapper {
    CustomRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Enumeration<String> getParameterNames() {
        Enumeration<String> enumeration = super.getParameterNames();
        ArrayList<String> list = Collections.list(enumeration);
        if (list.contains("token")) {
            list.add("uid");
            return Collections.enumeration(list);
        } else {
            return super.getParameterNames();
        }
    }

    /**
     * 获取请求参数值
     * @param name 参数名
     * @return 参数值
     */
    @Override
    public String[] getParameterValues(String name) {
        //修改参数值
        if ("uid".equals(name)) {
            return new String[]{"uid change"};
        }
        return super.getParameterValues(name);
    }
}
