package com.webflux.SpringReactive.service;

import com.webflux.SpringReactive.entity.Employee;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface EmployeeService {
    Mono<Employee> save(Employee employee);

    Flux<Employee> getAll();

    Mono<Employee> getById(Long id);

    Mono<Void> delete(Long id);

    Mono<Employee> update(Long id, Employee update);
}
