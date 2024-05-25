package com.medet.employeeservice.employee.usecases.deleteemployee;

import com.medet.employeeservice.usecase.UseCaseInput;

import java.util.UUID;

public record DeleteEmployeeVoidUseCaseInput(UUID id) implements UseCaseInput {}
