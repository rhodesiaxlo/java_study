package com.lsx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class HelloController {

    @RequestMapping(path = "hello")
    public String hello() {
        return "success";
    }
}
