package com.medet.employeeservice.employee.usecases.createemployee;

import com.medet.employeeservice.usecase.UseCaseOutput;

public record CreateEmployeeUseCaseOutput(CreateEmployeeDto createEmployeeDto) implements UseCaseOutput {}
