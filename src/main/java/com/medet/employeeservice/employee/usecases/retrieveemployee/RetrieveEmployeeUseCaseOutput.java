package com.medet.employeeservice.employee.usecases.retrieveemployee;

import com.medet.employeeservice.usecase.UseCaseOutput;

public record RetrieveEmployeeUseCaseOutput(RetrieveEmployeeDto retrieveEmployeeDto) implements UseCaseOutput {}
