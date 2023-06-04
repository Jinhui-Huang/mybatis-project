package com.itstudy;

import com.itstudy.mapper.EmpMapper;
import com.itstudy.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class MybatisDemo02ApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testConditionalQuery() {
        List<Emp> empList = empMapper.conditionalQuery(null, (short) 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        empList.stream().forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("tom111");
        emp.setImage("2.jpg");
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update(emp);
    }

    @Test
    public void testDeleteByIds() {
        List<Integer> idList = new ArrayList<>();
        Collections.addAll(idList, 1, 2, 3);
        empMapper.deleteByIds(idList);
    }

    @Test
    public void testGetById() {
        Emp emp = empMapper.getById(1);
        System.out.println(emp);
    }

}
