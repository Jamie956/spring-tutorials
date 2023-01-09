package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    /**
     * test http:
     *      method: get
     *      url: http://localhost:8080/home/aa
     * DispatcherServlet#doDispatch -> mappedHandler.applyPreHandle(..)
     * DispatcherServlet#doDispatch -> mappedHandler.applyPostHandle(..)
     * DispatcherServlet#doDispatch -> processDispatchResult(..)
     */
    @RequestMapping("/aa")
    @ResponseBody
    public String index() {
        System.out.println("------> controller");
        return "hi";
    }
}
