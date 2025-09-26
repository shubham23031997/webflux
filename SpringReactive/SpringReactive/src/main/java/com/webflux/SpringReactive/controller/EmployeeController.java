package com.webflux.SpringReactive.controller;

import com.webflux.SpringReactive.entity.Employee;
import com.webflux.SpringReactive.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Flux<Employee> getAllEmployee() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Employee>> getEmployeeById(@PathVariable Long id) {
        return employeeService.getById(id)
                .map(employee -> ResponseEntity.ok(employee)) // if found
                .defaultIfEmpty(ResponseEntity.notFound().build()); // if not found
    }

    @PostMapping
    public Mono<ResponseEntity<Employee>> createEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee)
                .map(savedEmployee -> ResponseEntity.ok(savedEmployee));
    }

    @PostMapping("/emp")
    public Mono<Employee> createBook(@RequestBody Employee employee) {
        return employeeService.save(employee);

    }


    @PutMapping("/{id}")
    public Mono<ResponseEntity<Employee>> updateEmployee(@PathVariable Long id,
                                                         @RequestBody Employee employee) {
        return employeeService.update(id, employee)
                .map(updatedEmployee -> ResponseEntity.ok(updatedEmployee))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
