package com.xiaojihua.m03.controller;

import com.xiaojihua.m03.dao.EmployeeDao;
import com.xiaojihua.m03.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    private EmployeeDao empDao;

    @GetMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> employees = empDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
}
