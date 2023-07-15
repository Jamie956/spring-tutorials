package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * handle request and response and view:
 * debug DispatcherServlet#doDispatch step mv = ha.handle(
 *
 * resolve view template:
 * debug DispatcherServlet#render step view = resolveViewName(
 */
@Controller
public class MyController {
    /**
     * Attribute set to http
     */
    @RequestMapping("/requestAttr")
    public String requestAttr(HttpServletRequest request) {
        request.setAttribute("kk", "request Attr");
        return "success";
    }
    /**
     * Attribute set to new ModelAndView, to http
     */
    @RequestMapping("/modelValue")
    public ModelAndView modelValue() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("kk", "model Value");
        mav.setViewName("success");
        return mav;
    }
    /**
     * Attribute set to param model, to http
     */
    @RequestMapping("/modelParam")
    public String modelParam(Model model) {
        model.addAttribute("kk", "model Param");
        return "success";
    }
    /**
     * Attribute set to param map, to http
     */
    @RequestMapping("/paramMap")
    public String paramMap(Map<String, Object> map) {
        map.put("kk", "param Map");
        return "success";
    }
    /**
     * Attribute set to param modelMap, to http
     */
    @RequestMapping("/paramModelMap")
    public String scope5(ModelMap model) {
        model.addAttribute("kk", "param ModelMap");
        return "success";
    }
    /**
     * Attribute set to session
     */
    @RequestMapping("/sessionAttr")
    public String sessionAttr(HttpSession session) {
        session.setAttribute("kk", "session Attr");
        return "success";
    }
    /**
     * Attribute set to app
     */
    @RequestMapping("/appAttr")
    public String appAttr(HttpSession session) {
        ServletContext context = session.getServletContext();
        context.setAttribute("kk", "app Attr");
        return "success";
    }
}
