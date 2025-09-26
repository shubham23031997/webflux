package com.webflux.SpringReactive.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("employee")
public class Employee {
    @Id
    private Long id;

    private String name;
    private String role;
    private Double salary;
}
