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
 * debug
 *
 * handle request and response and view
 * DispatcherServlet#doDispatch -> mv = ha.handle(..)
 *
 * resolve view template:
 * DispatcherServlet#render -> view = resolveViewName(..)
 */
@Controller
public class ScopeTest {

    /**
     * set value in request scope via servlet api HttpServletRequest
     *
     * test
     * http://localhost:8080/scope1
     */
    @RequestMapping("/scope1")
    public String scope1(HttpServletRequest request) {
        request.setAttribute("kk", "scope1");
        return "success";
    }

    /**
     * set value in ModelAndView and set in request scope via render model
     *
     * test:
     * http://localhost:8080/scope2
     *
     * debug
     * DispatcherServlet#doDispatch -> DispatcherServlet#processDispatchResult
     * -> DispatcherServlet#render -> view.render(..)
     */
    @RequestMapping("/scope2")
    public ModelAndView scope2() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("kk", "scope2");
        mav.setViewName("success");
        return mav;
    }

    /**
     * set value in Model and set in request scope via render model
     *
     * test:
     * http://localhost:8080/scope3
     */
    @RequestMapping("/scope3")
    public String scope3(Model model) {
        model.addAttribute("kk", "scope3");
        return "success";
    }

    /**
     * set value in Map and set in request scope via render model
     *
     * test:
     * http://localhost:8080/scope4
     */
    @RequestMapping("/scope4")
    public String scope4(Map<String, Object> map) {
        map.put("kk", "scope4");
        return "success";
    }

    /**
     * set value in ModelMap and set in request scope via render model
     *
     * test: http://localhost:8080/scope5
     */
    @RequestMapping("/scope5")
    public String scope5(ModelMap model) {
        model.addAttribute("kk", "scope5");
        return "success";
    }

    /**
     * set value in session scope via HttpSession
     *
     * test: http://localhost:8080/scope6
     */
    @RequestMapping("/scope6")
    public String scope6(HttpSession session) {
        session.setAttribute("kk", "scope6");
        return "success";
    }

    /**
     * set value in application scope via HttpSession context
     *
     * test: http://localhost:8080/scope7
     */
    @RequestMapping("/scope7")
    public String scope7(HttpSession session) {
        ServletContext context = session.getServletContext();
        context.setAttribute("kk", "scope7");
        return "success";
    }
}
