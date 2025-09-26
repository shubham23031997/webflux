package com.webflux.SpringReactive.dto;


import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmployeeDto {

    // R2DBC uses org.springframework.data.annotation.Id
    @JsonTypeId
    private Long id;

    private String name;
    private String role;
    private Double salary;
}