package com.wang.dao;

import com.wang.pojo.Department;
import com.wang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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
//员工dao
public class EmployeeDao
{
    private static Map <Integer, Employee> employees = null;

    //员工所属部门
    @Autowired
    private DepartmentDao departmentDao;

    static
    {
        //创建部门
        employees = new HashMap <>();
        employees.put(1, new Employee(1, "蒋莹莹", "123@qq.com", 1, new Department(1, "后勤部")));
        employees.put(2, new Employee(2, "李墁墁", "123@qq.com", 1, new Department(1, "后勤部")));
        employees.put(3, new Employee(3, "陈昌霖", "123@qq.com", 1, new Department(1, "后勤部")));
        employees.put(4, new Employee(4, "钟啊清", "123@qq.com", 1, new Department(1, "后勤部")));
        employees.put(5, new Employee(5, "廖明月", "123@qq.com", 1, new Department(1, "后勤部")));
    }

    //主键自增
    private static Integer initId = 6;

    //增加员工
    public void save(Employee employee)
    {
        if (employee.getId() == null)
        {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询全部员工
    public Collection <Employee> getAll()
    {
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id)
    {
        return employees.get(id);
    }

    //通过id删除员工
    public void delete(Integer id)
    {
        employees.remove(id);

    }
}
