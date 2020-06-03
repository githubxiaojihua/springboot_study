package com.xiaojihua.m03.controller;

import com.xiaojihua.m03.dao.DepartmentDao;
import com.xiaojihua.m03.dao.EmployeeDao;
import com.xiaojihua.m03.entities.Department;
import com.xiaojihua.m03.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    private EmployeeDao empDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> employees = empDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddEmp(Model model){
        //获取部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("保存的员工信息："+employee);
        empDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEdit(@PathVariable("id") Integer id,Model model){
        Employee employee = empDao.get(id);
        model.addAttribute("emp",employee);
        //获取部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String edit(Employee employee){
        System.out.println("要修改的员工信息：" + employee);
        empDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        empDao.delete(id);
        return "redirect:/emps";
    }
}
