package com.wang.dao;

import com.wang.pojo.Department;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/10/5 0005
 */

@Repository
//部门dao
public class DepartmentDao
{
    //模拟数据库中的数据

    private static Map <Integer, Department> departments = null;

    static
    {
        //创建部门"
        departments = new HashMap <>();
        departments.put(1, new Department(1, "后勤部"));
        departments.put(2, new Department(2, "教学部"));
        departments.put(3, new Department(3, "学生部"));
        departments.put(4, new Department(4, "检查部"));
        departments.put(5, new Department(5, "老六部"));
    }

    //获得所有部门信息

    public Collection <Department> getDepartment()
    {
        return departments.values();
    }

    //通过id获得部门
    public Department getDepartmentById(Integer id)
    {
        return departments.get(id);
    }
}
