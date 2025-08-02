package org.example.controller;

import cn.hutool.core.io.IoUtil;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/*
 * @Description：用户信息Controller
 */
@RestController//ResponseBody 作用：将controller返回的数据,直接作为响应体的数据直接响应，返回对象是对象/集合->json->响应
public class UserController {
//    @RequestMapping("/list")
//    public List<User> list() throws Exception{
//
//        //1 加载并读取user.txt
//        //绝对路径 不推荐
//        //InputStream in=new FileInputStream(new File("D:\\DkJavaCode\\JavaWeb\\JavaWebProject\\JavaWeb\\_02SpringBootWebDemo\\src\\main\\resources\\user.txt"));
//        //通过字节码对象获取类加载器
//        InputStream in=this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
//
//        //2 解析用户信息，封装为用户对象->list集合
//        List<User> userList = lines.stream().map(line->{
//            String[] parts = line.split(",");
//            Integer id=Integer.parseInt(parts[0]);//将String转换为Integer
//            String username=parts[1];
//            String password=parts[2];
//            String name=parts[3];
//            Integer age=Integer.parseInt(parts[4]);
//            LocalDateTime updateTime=LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));//将String转换为LocalDateTime
//            return new User(id,username,password,name,age,updateTime);
//        }).toList();
//
//        //3 返回数据(json)
//        return userList;
//    }

    //private UserService userService=new UserServiceImpl();

    //方式一：属性注入
    @Autowired//运行时会自动查询该类型Bean对象，并赋值给该成员变量
    private UserService userService;

    //方式二：构造器注入
//    private final UserService userService;
//    @Autowired//仅有一个构造器时，可省略@Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //方式三：setter注入
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @RequestMapping("/list")
    public List<User> list() throws Exception{
        //1 调用service
        List<User> userList=userService.list();
        //2 响应数据
        return userList;
    }
}
