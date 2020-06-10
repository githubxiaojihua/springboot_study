package com.xiaojihua.m06_springboot_mybatis.mapper;

import com.xiaojihua.m06_springboot_mybatis.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/*@Mapper*/
public interface EmployeeMapper {
    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);
}
