package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

import java.util.List;

@Mapper //应用程序在运行时，会自动为该接口创建一个实现类对象（代理对象），自动将该实现类对象存入IOC容器中 bean
public interface UserMapper {
    @Select("select * from user")//查询
    public List<User> findALL();
}
