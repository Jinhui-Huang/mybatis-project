package com.itstudy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForLogin {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;

}
