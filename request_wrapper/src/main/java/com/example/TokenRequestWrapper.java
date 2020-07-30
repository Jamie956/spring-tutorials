package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class TokenRequestWrapper extends HttpServletRequestWrapper {
    TokenRequestWrapper(HttpServletRequest request) {
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

    @Override
    public String[] getParameterValues(String name) {
        if ("uid".equals(name)) {
            return new String[]{"aaaaaa"};
        }
        return super.getParameterValues(name);
    }
}
