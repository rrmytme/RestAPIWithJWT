package org.RestWithJWT.Repository;

import org.RestWithJWT.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartment(String department);
}

