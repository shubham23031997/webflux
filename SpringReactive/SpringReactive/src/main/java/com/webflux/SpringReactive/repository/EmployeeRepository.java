package com.webflux.SpringReactive.repository;

import com.webflux.SpringReactive.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
    // sample custom finder (returns 0..1 result)
    Mono<Employee> findByName(String name);
}
