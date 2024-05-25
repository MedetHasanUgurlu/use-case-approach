package com.medet.employeeservice.employee.usecases.createemployee;

import com.medet.employeeservice.usecase.UseCaseInput;

public record CreateEmployeeUseCaseInput(String firstName, String lastName, String departmentName) implements UseCaseInput {}
