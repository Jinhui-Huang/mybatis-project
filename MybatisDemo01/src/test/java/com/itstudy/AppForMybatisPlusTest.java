package com.itstudy;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itstudy.mapper.EmpMapper;
import com.itstudy.mapper.UserForLoginMapper;
import com.itstudy.pojo.User;
import com.itstudy.pojo.UserForLogin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;

@SpringBootTest
public class AppForMybatisPlusTest {

    @Autowired
    private UserForLoginMapper userForLoginMapper;

    @Autowired
    private EmpMapper empMapper;

    @Test
    void testGetAll() {
        /*List<UserForLogin> userForLoginList = userForLoginMapper.selectList(null);
        userForLoginList.forEach(System.out::println);*/
        QueryWrapper<UserForLogin> queryWrapper = new QueryWrapper<>();
        //一, 按条件查询
        //queryWrapper.lt("age", 30);
        //二, lambda表达式查询
        queryWrapper.lambda().lt(UserForLogin::getAge, 30);
        List<UserForLogin> userForLoginList = userForLoginMapper.selectList(queryWrapper);
        System.out.println(userForLoginList);

        //LambadaQueryWrapper
        LambdaQueryWrapper<UserForLogin> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.lt(UserForLogin::getAge, 20).or().gt(UserForLogin::getAge, 22);
        List<UserForLogin> userForLoginList1 = userForLoginMapper.selectList(lambdaQueryWrapper);
        System.out.println(userForLoginList1);
    }

    @Test
    void testInsert() {
        UserForLogin user = new UserForLogin();
        user.setName("王五");
        user.setAge(24);
        user.setTel("00-8888888");
        userForLoginMapper.insert(user);
    }

    @Test
    void testDelete() {
        userForLoginMapper.deleteById("1675012665972097026");
    }

    @Test
    void testUpdate() {
        UserForLogin user = new UserForLogin();
        user.setId(4L);
        user.setName("赵六");
        userForLoginMapper.updateById(user);
    }

    @Test
    void testGetByPage() {
        /*
         * 需要配置MyBatis的拦截器
         * */
        IPage<UserForLogin> page = new Page<UserForLogin>(1, 5);
        userForLoginMapper.selectPage(page, null);
        System.out.println("当前页码值:" + page.getCurrent());
        System.out.println("每页显示数:" + page.getSize());
        System.out.println("一共多少页:" + page.getPages());
        System.out.println("一共多少条:" + page.getTotal());
        System.out.println("数据:" + page.getRecords());


    }
}
