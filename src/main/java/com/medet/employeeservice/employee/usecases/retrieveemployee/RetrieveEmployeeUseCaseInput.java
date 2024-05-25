package com.medet.employeeservice.employee.usecases.retrieveemployee;

import com.medet.employeeservice.usecase.UseCaseInput;

import java.util.UUID;

public record RetrieveEmployeeUseCaseInput(UUID id)
    implements UseCaseInput {}
