package com.raj.EmployeeDetailsSystem.Service;

import com.raj.EmployeeDetailsSystem.Entity.Employee;
import com.raj.EmployeeDetailsSystem.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public List<Employee> getEmployee(){
        return employeeRepo.findAll();
    }
    public Employee getEmployeeById(Integer id){
        Optional<Employee> employee1 = employeeRepo.findById(id);
        return employee1.get();
    }
    public Employee updateEmployee(Employee newEmployee, Integer id){
        Optional<Employee> employee1 = employeeRepo.findById(id);
        if(employee1.isPresent()){
            Employee oldEmployee = employee1.get();
            oldEmployee.setFirstName(newEmployee.getFirstName());
            oldEmployee.setLastName(newEmployee.getLastName());
            oldEmployee.setEmail(newEmployee.getEmail());
            oldEmployee.setSalary(newEmployee.getSalary());
            oldEmployee.setType(newEmployee.getType());
            employeeRepo.save(oldEmployee);
            return employeeRepo.findById(id).get();
        }else{
            return null;
        }
    }
    public List<Employee> deleteEmployee(Integer id){
        employeeRepo.deleteById(id);
        return employeeRepo.findAll();
    }
}
