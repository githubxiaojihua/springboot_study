package com.xiaojihua.m06_springboot_mybatis.mapper;

import com.xiaojihua.m06_springboot_mybatis.bean.Department;
import org.apache.ibatis.annotations.*;
//在入口类上注释了@mapperscan
/*@Mapper*/
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getDepartmentById(Integer id);

    @Delete("delete from department where id=#{id}")
    int deleteDepartmentById(Integer id);

    @Options(useGeneratedKeys=true,keyProperty="id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    int insertDepartment(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    int updateDepartment(Department department);
}
