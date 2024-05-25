package com.medet.employeeservice.department.usecases.retrievedepartment;

import java.util.UUID;

public record RetrieveDepartmentDto(UUID id, String name, String description, String code) {}
