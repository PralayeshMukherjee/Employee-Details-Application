package com.raj.EmployeeDetailsSystem.Repository;

import com.raj.EmployeeDetailsSystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
