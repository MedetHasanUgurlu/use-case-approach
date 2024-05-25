package com.medet.employeeservice.department.usecases.createdepartment;


import java.util.UUID;

public record CreateDepartmentDto(UUID id,String name, String description, String code) {}
