package com.medet.employeeservice.employee.usecases.createemployee;

import java.util.UUID;

public record CreateEmployeeDto(UUID id,String firstName, String lastName,String departmentName)  {}
