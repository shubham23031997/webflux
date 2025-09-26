package com.webflux.SpringReactive.serviceImpl;

import com.webflux.SpringReactive.entity.Employee;
import com.webflux.SpringReactive.repository.EmployeeRepository;
import com.webflux.SpringReactive.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    //with the required args constructor we are able to achieve constructor based DI

    // list all employees
    @Override
    public Flux<Employee> getAll() {
        return repository.findAll();
    }

    // get one by id
    @Override
    public Mono<Employee> getById(Long id) {
        return repository.findById(id);
    }

    public Mono<Void> delete(Long id) {
        return repository.deleteById(id);
    }

    @Override
    // create/save employee
    public Mono<Employee> save(Employee employee) {
        // if id is null DB will auto-generate
        return repository.save(employee);
    }

    @Override
    // update: find existing, mutate, save
    public Mono<Employee> update(Long id, Employee update) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setName(update.getName());
                    existing.setRole(update.getRole());
                    existing.setSalary(update.getSalary());
                    return repository.save(existing);
                });
    }


}
