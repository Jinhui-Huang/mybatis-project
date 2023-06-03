package com.itstudy.mapper;

import com.itstudy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //在运行时, 会自动生成该接口的实现类对象(代理对象), 并且将该对象交给IoC容器管理
public interface UserMapper {
    //查询全部用户的信息
    @Select("select customer_id, first_name, last_name, birth_date, phone from customers " +
            "limit 10")
    List<User> list();

}
