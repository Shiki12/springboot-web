package com.shiki.springbootweb.mapper;

import com.shiki.springbootweb.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//模拟数据库中的数据 ，部门的mapper对象
@Repository
public class DepartmentMapper {
    private static Map<Integer, Department> departments = null;
    static {
        //创建部门表
        departments =new HashMap<Integer, Department>();

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));

    }


    //获得所有部门信息
    public Collection<Department> getDepartment(){

        return departments.values();
    }

    public  Department getDepartmentById(int id){
        return departments.get(id);
    }

}
