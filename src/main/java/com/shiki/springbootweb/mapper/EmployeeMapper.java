package com.shiki.springbootweb.mapper;

import com.shiki.springbootweb.pojo.Department;
import com.shiki.springbootweb.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//员工
@Repository
public class EmployeeMapper {
    private static Map<Integer, Employee> employees = null;

    //员工所属部门
    @Autowired
    DepartmentMapper departmentMapper;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001,"aa","24454545@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"bb","adkah@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"cc","24dad545@qq.com",1,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"dd","2dada545@qq.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"ee","244dadfa545@qq.com",1,new Department(105,"后勤部")));

    }
    //定义主键
    private  static  Integer id=1006;
    //增加一个员工
     public void save(Employee employee){
         if (employee.getId()==null){
             employee.setId(id++);
         }
         employee.setDepartment(departmentMapper.getDepartmentById(employee.getDepartment().getId()));

         employees.put(employee.getId(),employee);

     }

     // 获得全部
    public Collection<Employee> getAll(){

         return employees.values();
    }
    //通过id查询
    public  Employee getEmployeeById(int id){

         return  employees.get(id);
    }

    //删除一个id
    public  Employee deleteById(int id){

        return  employees.remove(id);
    }


}