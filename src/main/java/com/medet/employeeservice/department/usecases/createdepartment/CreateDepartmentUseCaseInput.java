package com.medet.employeeservice.department.usecases.createdepartment;

import com.medet.employeeservice.usecase.UseCaseInput;

public record CreateDepartmentUseCaseInput(String name,String description,String code) implements UseCaseInput {}
