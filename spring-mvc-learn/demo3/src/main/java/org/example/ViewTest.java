package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewTest {
    /**
     * http://localhost:8080/home/view1
     *
     * DispatcherServlet#render -> view = resolveViewName(..) -> create ThymeleafView
     */
    @RequestMapping("/view1")
    public String view1() {
        return "view";
    }

    /**
     * http://localhost:8080/home/view2
     * forward to /view1, url -> http://localhost:8080/home/view2
     *
     * DispatcherServlet#render -> view = resolveViewName(..) -> create internal resource view
     */
    @RequestMapping("/view2")
    public String view2() {
        return "forward:/view1";
    }

    /**
     * http://localhost:8080/home/view3
     * redirect to /view1, url -> http://localhost:8080/home/view1
     *
     * DispatcherServlet#render -> view = resolveViewName(..) -> create redirect view
     */
    @RequestMapping("/view3")
    public String view3() {
        return "redirect:/view1";
    }

}
