package com.itstudy;

import com.itstudy.mapper.EmpMapper;
import com.itstudy.mapper.UserMapper;
import com.itstudy.pojo.Emp;
import com.itstudy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Consumer;


@SpringBootTest  //springboot整合单元测试的注解
class AppTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testListUser() {
        List<User> userList = userMapper.list();
        userList.stream().forEach(System.out::println);
    }

    @Test
    public void testListEmp() {
        List<Emp> empList = empMapper.list();
        empList.stream().forEach((Consumer<? super Emp>) System.out::println);
    }
}
