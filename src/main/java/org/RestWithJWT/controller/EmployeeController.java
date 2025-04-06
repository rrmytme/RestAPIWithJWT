package org.RestWithJWT.controller;

import org.RestWithJWT.Model.Employee;
import org.RestWithJWT.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        return service.save(emp);
    }

    @GetMapping("/department/{dept}")
    public List<Employee> getByDepartment(@PathVariable String dept) {
        return service.getByDepartment(dept);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}

