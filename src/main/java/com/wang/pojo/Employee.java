package com.wang.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/10/5 0005
 */

@Data
@NoArgsConstructor
//员工表
public class Employee
{
    private Integer    id;
    private String     name;
    private String     email;
    //0  女  1 男
    private Integer    gender;
    private Department department;
    private Date       birth;

    public Employee(Integer id, String name, String email, Integer gender, Department department)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //默认日期
        this.birth = new Date();
    }
}
