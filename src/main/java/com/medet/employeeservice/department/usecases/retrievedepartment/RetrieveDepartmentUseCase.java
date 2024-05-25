package com.medet.employeeservice.department.usecases.retrievedepartment;

import com.medet.employeeservice.department.Department;
import com.medet.employeeservice.department.DepartmentRepository;
import com.medet.employeeservice.usecase.UseCase;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RetrieveDepartmentUseCase
    implements UseCase<RetrieveDepartmentUseCaseInput, RetrieveDepartmentUseCaseOutput> {
  private final DepartmentRepository departmentRepository;

  public RetrieveDepartmentUseCase(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public RetrieveDepartmentUseCaseOutput execute(RetrieveDepartmentUseCaseInput input) {
    Optional<Department> optionalDepartment = departmentRepository.findById(input.id());
    return optionalDepartment
        .map(
            department ->
                new RetrieveDepartmentUseCaseOutput(buildRetrieveDepartmentDto(department)))
        .orElseThrow(EntityNotFoundException::new);
  }

  private static RetrieveDepartmentDto buildRetrieveDepartmentDto(Department department) {
    return new RetrieveDepartmentDto(
        department.getId(),
        department.getName(),
        department.getDescription(),
        department.getCode());
  }
}
