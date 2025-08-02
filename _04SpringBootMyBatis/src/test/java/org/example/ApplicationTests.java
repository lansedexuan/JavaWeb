package org.example;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest//单元测试的注解，当前测试类中的测试方法运行时，会启动Springboot项目，IOC容器创建好了
class ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findALL();
        //userList.forEach(user->System.out.println(user));
        userList.forEach(System.out::println);
    }
}
