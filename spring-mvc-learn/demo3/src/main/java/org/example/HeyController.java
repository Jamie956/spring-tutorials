package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class HeyController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * using servlet api shared request scope data
     *
     * debug DispatcherServlet#doDispatch -> mv = ha.handle(..)
     */
    @RequestMapping("/test1")
    public String test1(HttpServletRequest request) {
        request.setAttribute("kk", "test1");
        return "success";
    }

    /**
     * ModelAndView: set model value -> view
     */
    @RequestMapping("/test2")
    public ModelAndView test2() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("kk", "test2");
        mav.setViewName("success");
        return mav;
    }

    /**
     * setting model value
     */
    @RequestMapping("/test3")
    public String test3(Model model) {
        model.addAttribute("kk", "test3");
        return "success";
    }

    /**
     * mapping request scope to map and set value
     */
    @RequestMapping("/test4")
    public String test4(Map<String, Object> map) {
        map.put("kk", "test4");
        return "success";
    }

    @RequestMapping("/test5")
    public String test5(ModelMap model) {
        model.addAttribute("kk", "test5");
        return "success";
    }

    /**
     * shared session scope value
     */
    @RequestMapping("/test6")
    public String test6(HttpSession session) {
        session.setAttribute("kk", "test6");
        return "success";
    }

    /**
     * setting application scope value
     */
    @RequestMapping("/test7")
    public String test7(HttpSession session) {
        ServletContext context = session.getServletContext();
        context.setAttribute("kk", "test7");
        return "success";
    }
}
