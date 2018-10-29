package com.guohaoshiye.yueba;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: com.guohaoshiye.yueba.HelloYueba
 * Author:   liufei32@outlook.com
 * Date:     2018/10/29 11:54
 * Description: HelloWorld file of the project yueba!
 * Aha-eureka:
 *******************************************************************************/
@RequestMapping("greet")
@Controller
public class HelloYueba {

    @RequestMapping("hello")
    public String greet(Model model) {
        model.addAttribute("name", "Swagger-Ranger");
        model.addAttribute("url", "http://127.0.0.1:8080");
        return "HelloYueba";
    }
}
