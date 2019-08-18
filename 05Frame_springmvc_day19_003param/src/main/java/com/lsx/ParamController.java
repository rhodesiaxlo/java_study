package com.lsx;


import com.lsx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("param")
public class ParamController {

    @RequestMapping("/single")
    public String save(String name, String password) {

        return "param";
    }

    @RequestMapping("/entity")
    public String entity(User u) {
        System.out.println("封装为user实体，结果为" + u);
        return "param";
    }

    @RequestMapping("/ref")
    public String refObj(User u) {
        System.out.println("user 中包含引用对象 account, 结果为 " + u);
        return "param";
    }

    @RequestMapping("/col")
    public String coll(User u) {
        System.out.println("user 中包含集合对象，结果为 " + u);
        return "param";
    }


    @RequestMapping("/mv")
    public ModelAndView mv() {
        ModelAndView mv = new ModelAndView("param");
        mv.addObject("name", "鲁仕鑫");
        return  mv;
    }

    @RequestMapping("/date")
    public  String date(User u) {
        /**
         * 自定义类型转换器使用步骤
         * 1. 定义类实现converter<s,k>接口
         * 2. spring mvc converterservicefactorbean 中增加该类
         * 3.
         <mvc:annotation-driven conversion-service="conversionService"/> 替换现有的转换器
         */
        System.out.println("转换日期...");
        System.out.println(" 接收成功, 结果为 " + u);
        return "param";
    }

    @RequestMapping("/ses")
    public  String ses(HttpServletRequest req, HttpServletResponse resp) {
        // 不需要跳转，session 自动存储
        HttpSession session = req.getSession();
        session.setAttribute("name", "session_value");
        return "param";
    }

    @RequestMapping("/forward")
    public String forward() {
        System.out.println(" forward 页面" );
        return "forward";
    }

    @RequestMapping("/redirect")
    public String redi() {
        System.out.println(" redirect 页面 ");
        return "redi";
    }

    @RequestMapping("/station")
    public String station(HttpServletRequest request) {
        // 起始页面，跳转和转发都是基于这个页面
        return "forward:forward";
//        String contextPath = request.getContextPath();
//
//        return "redirect:" + contextPath+"/redirect";
    }

    @RequestMapping("/station2")
    public ModelAndView station2(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String path2 =  "redirect:/param/redirect";

        System.out.println("redirect path = " + path2);

        String path3 =  "forward:forward";


//        ModelAndView mv2 = new ModelAndView(path2);
//
//        return mv2;

        request.setAttribute("request_value", "request_value_msg");
        ModelAndView mv3 = new ModelAndView(path3);
        return mv3;

        // 转发
    }

    @RequestMapping("/pa")
    public String params(@RequestParam(required = true) String name, String password, String age) {
        System.out.println("name = " + name + " password = " + password + " age =" + age);
        return  "param";
    }




}
