package com.medet.employeeservice.department.usecases.createdepartment;

import com.medet.employeeservice.department.Department;
import com.medet.employeeservice.department.DepartmentRepository;
import com.medet.employeeservice.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateDepartmentUseCase
    implements UseCase<CreateDepartmentUseCaseInput, CreateDepartmentUseCaseOutput> {
  private final DepartmentRepository departmentRepository;

  @Override
  public CreateDepartmentUseCaseOutput execute(final CreateDepartmentUseCaseInput input) {
    if (Objects.isNull(input)) throw new IllegalArgumentException();
    final Department department = new Department();
    department.setCode(input.code());
    department.setName(input.name());
    department.setDescription(input.description());
    Department savedDepartment = departmentRepository.save(department);
    return new CreateDepartmentUseCaseOutput(buildCreateDepartmentDto(savedDepartment));
  }

  public static CreateDepartmentDto buildCreateDepartmentDto(final Department department) {
    return new CreateDepartmentDto(
        department.getId(),
        department.getName(),
        department.getDescription(),
        department.getCode());
  }
}
