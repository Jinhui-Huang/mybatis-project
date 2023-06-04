package com.itstudy.mapper;


import com.itstudy.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    List<Emp> conditionalQuery(String name, Short gender, LocalDate begin, LocalDate end);

    void update(Emp emp);

    void deleteByIds(List<Integer> idList);

    Emp getById(Integer id);

}
