package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoImpl;
import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//@Component//将当前类交给IOC容器管理
@Service
public class UserServiceImpl implements UserService {
    //private UserDao userDao=new UserDaoImpl();
    @Autowired//运行时会自动查询该类型Bean对象，并赋值给该成员变量
    private UserDao userDao;
    @Override
    public List<User> list() {
        //1 调用dao,获取数据
        List<String> lines = userDao.findAll();

        //2 解析用户信息，封装为用户对象->list集合
        List<User> userList = lines.stream().map(line->{
            String[] parts = line.split(",");
            Integer id=Integer.parseInt(parts[0]);//将String转换为Integer
            String username=parts[1];
            String password=parts[2];
            String name=parts[3];
            Integer age=Integer.parseInt(parts[4]);
            LocalDateTime updateTime=LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));//将String转换为LocalDateTime
            return new User(id,username,password,name,age,updateTime);
        }).toList();

        return userList;
    };
}
