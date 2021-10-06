package com.wang.controller;

import com.wang.dao.DepartmentDao;
import com.wang.dao.EmployeeDao;
import com.wang.pojo.Department;
import com.wang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Collection;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/10/5 0005
 */
@Controller
public class employeeController
{
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model)
    {
        Collection <Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        System.out.println("=====================");
        System.out.println(employees);

        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddEmp(Model model)
    {
        Collection <Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Model model, Employee employee)
    {
        //dao层方法保存员工信息
        employeeDao.save(employee);
        //添加的操作

        System.out.println("========" + employee);
        return "redirect:/emps";
    }

    //去员工修改页面
    @GetMapping("emp/{id}")

    public String toUpdateEmp(@PathVariable("id") Integer id, Model model)
    {
        Employee employeeById = employeeDao.getEmployeeById(id);
        System.out.println("=============");
        System.out.println(employeeById);
        model.addAttribute("emp", employeeById);

        Collection <Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee)
    {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delEmp/{id}")

    public String delEmp(@PathVariable("id") Integer id)
    {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
