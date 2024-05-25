package com.medet.employeeservice.department.usecases.retrievedepartment;

import com.medet.employeeservice.usecase.UseCaseInput;

import java.util.UUID;

public record RetrieveDepartmentUseCaseInput(UUID id) implements UseCaseInput {}

