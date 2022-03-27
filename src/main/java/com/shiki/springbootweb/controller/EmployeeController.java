package com.shiki.springbootweb.controller;

        import com.shiki.springbootweb.mapper.DepartmentMapper;
        import com.shiki.springbootweb.mapper.EmployeeMapper;
        import com.shiki.springbootweb.pojo.Department;
        import com.shiki.springbootweb.pojo.Employee;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import java.util.Collection;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;



    @RequestMapping("/emps")
    public  String  selectAll(Model model){
        Collection<Employee> employees = employeeMapper.getAll();
        model.addAttribute("emps",employees);
        return "emps/list";
    }


//去添加页面
    @GetMapping("/toAdd")
    public  String toAddPage(Model model){
        Collection<Department> departments = departmentMapper.getDepartment();
        model.addAttribute("departments",departments);
        return "emps/add";
    }

    //添加用户
    @PostMapping("/toAdd")
    public  String add(Employee employee){

        System.out.println("============>"+employee);

        employeeMapper.save(employee);

        System.out.println("============>"+employee);

        return "redirect:/employee/emps";

    }

    //去修改页面
    @GetMapping("/toupdate/{id}")
    public  String toUpdate(@PathVariable("id") int id,Model model){

        //查出原来的数据
        Employee employee = employeeMapper.getEmployeeById(id);

        System.out.println("==========>修改的对象"+employee);
        //传到前端
        model.addAttribute("emp",employee);
        //修改部门的下拉框
        Collection<Department> departments = departmentMapper.getDepartment();
        model.addAttribute("departments",departments);

        return "emps/update";
    }
    //修改用户
    @PostMapping("/update")
    public String update(Employee employee){
        System.out.println("========>"+employee);
        employeeMapper.save(employee); //修改就是覆盖之前的我们写的
        return "redirect:/employee/emps";
    }

    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") int id){

        System.out.println("=======删除的用户=======>"+employeeMapper.getEmployeeById(id));

        employeeMapper.deleteById(id);

        return "redirect:/employee/emps";
    }







}
