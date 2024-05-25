package com.medet.employeeservice.department.usecases.createdepartment;

import com.medet.employeeservice.usecase.UseCaseOutput;

public record CreateDepartmentUseCaseOutput(CreateDepartmentDto createDepartmentDto) implements UseCaseOutput {}
