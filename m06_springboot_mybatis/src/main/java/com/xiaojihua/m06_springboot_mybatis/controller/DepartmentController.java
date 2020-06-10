package com.xiaojihua.m06_springboot_mybatis.controller;

import com.xiaojihua.m06_springboot_mybatis.bean.Department;
import com.xiaojihua.m06_springboot_mybatis.bean.Employee;
import com.xiaojihua.m06_springboot_mybatis.mapper.DepartmentMapper;
import com.xiaojihua.m06_springboot_mybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    //注入mapper
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    //查询department
    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return departmentMapper.getDepartmentById(id);
    }

    //插入department
    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDepartment(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }
}
