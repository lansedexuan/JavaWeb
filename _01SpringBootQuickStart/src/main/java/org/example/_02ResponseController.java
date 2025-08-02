package org.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class _02ResponseController {
    /*
        方式一 ：使用HttpServletResponse响应
     */
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws Exception{
        //1 设置响应状态码
        response.setStatus(401);//正常响应200，通常不用设置状态码

        //2 设置响应头
        response.setHeader("name","zhangsan");

        //3 设置响应体
        response.getWriter().write("<h1>hello world</h1>");
    }

    @RequestMapping("/response2")
    public ResponseEntity<String> response2(){
        return ResponseEntity.status(401)
                .header("name","zhangsan")
                .body("<h1>hello world!</h1>");
    }
}
