package org.RestWithJWT.Services;

import org.RestWithJWT.Model.Employee;
import org.RestWithJWT.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee save(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> getByDepartment(String dept) {
        return repo.findByDepartment(dept);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}

