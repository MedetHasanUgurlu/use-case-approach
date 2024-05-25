package com.medet.employeeservice.department.usecases.retrievedepartment;

import com.medet.employeeservice.usecase.UseCaseOutput;

public record RetrieveDepartmentUseCaseOutput(RetrieveDepartmentDto retrieveDepartmentDto) implements UseCaseOutput {}
