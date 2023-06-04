package com.itstudy.mapper;

import com.itstudy.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select * from emp")
    List<Emp> list();

    @Delete("delete from emp where id = #{id}")
    void delete(Integer id);
    //int delete(Integer id);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "    VALUES (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime}" +
            "    where id = #{id}")
    void update(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp selectById(Integer id);

    //条件查询
    @Select("select * from emp where name like concat('%', #{name}, '%') and " +
            "gender = #{gender} and " +
            "entrydate between #{begin} and #{end}" +
            "    order by update_time desc")
    List<Emp> conditionalQuery(String name, Short gender, LocalDate begin, LocalDate end);
}
