package org.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//当前类是请求处理类
public class _00HelloController {
    @RequestMapping("/hello")//请求路径
    public String hello(String name){
        System.out.println("name: "+name);
        return "Hello "+name+"~";
    }
}
