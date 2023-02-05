package org.example;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//todo html.jsp not found
public class HelloController implements Controller {
    /**
     * test:
     *      get
     *      http://localhost:8080/test
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}