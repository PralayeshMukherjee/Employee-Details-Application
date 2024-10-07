package com.raj.EmployeeDetailsSystem.Controller;

import com.raj.EmployeeDetailsSystem.Entity.Employee;
import com.raj.EmployeeDetailsSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee saveData(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee(){
        return employeeService.getEmployee();
    }
    @GetMapping("/getEmployeeById")
    public Employee getEmployeeById(@RequestParam Integer id){
        return employeeService.getEmployeeById(id);
    }
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee,@RequestParam Integer id){
        return employeeService.updateEmployee(employee,id);
    }
    @DeleteMapping("/deleteEmployee")
    public List<Employee> deleteEmployee(@RequestParam Integer id){
        return employeeService.deleteEmployee(id);
    }
}
