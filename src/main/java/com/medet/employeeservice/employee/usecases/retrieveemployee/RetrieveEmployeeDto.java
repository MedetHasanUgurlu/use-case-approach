package com.medet.employeeservice.employee.usecases.retrieveemployee;

import java.util.UUID;

public record RetrieveEmployeeDto(
    UUID id, String firstName, String lastName, String departmentName) {}
