package com.wang.controller;

import com.wang.dao.EmployeeDao;
import com.wang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/emps")
    public String list(Model model)
    {
        Collection <Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        System.out.println("=====================");
        System.out.println(employees);

        return "emp/list";
    }
}
