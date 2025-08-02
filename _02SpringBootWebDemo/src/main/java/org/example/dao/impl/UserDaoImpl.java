package org.example.dao.impl;

import cn.hutool.core.io.IoUtil;
import org.example.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//@Component//将当前类交给IOC容器管理
//@Repository("userDao")//指定Bean名字
@Repository//Bean名字默认首字母小写
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll() {
        //1 加载并读取user.txt 通过字节码对象获取类加载器
        InputStream in=this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
