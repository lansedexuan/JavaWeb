package org.example;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class _01RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        //1 获取请求方式
        String method =request.getMethod();//GET POST
        System.out.println("请求方式:"+method);

        //2 获取请求路径：URL地址
        String url = request.getRequestURL().toString();//http://localhost:8080/request
        System.out.println("请求路径:"+url);
        String uri =request.getRequestURI();
        System.out.println("资源访问路径uri:"+uri);

        //3 获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议:"+protocol);

        //4 获取请求参数name
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("请求参数name:"+name+"age:"+age);

        //5 获取请求头Accept
        String header = request.getHeader("Accept");
        System.out.println("请求头Accept:"+header);

        return "OK";
    }
}
