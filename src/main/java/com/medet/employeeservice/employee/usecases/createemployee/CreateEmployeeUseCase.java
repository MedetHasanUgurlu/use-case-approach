package com.medet.employeeservice.employee.usecases.createemployee;

import com.medet.employeeservice.department.Department;
import com.medet.employeeservice.department.DepartmentRepository;
import com.medet.employeeservice.employee.Employee;
import com.medet.employeeservice.employee.EmployeeRepository;
import com.medet.employeeservice.usecase.UseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateEmployeeUseCase
    implements UseCase<CreateEmployeeUseCaseInput, CreateEmployeeUseCaseOutput> {
  private final EmployeeRepository employeeRepository;
  private final DepartmentRepository departmentRepository;

  public CreateEmployeeUseCase(
      final EmployeeRepository employeeRepository,
      final DepartmentRepository departmentRepository) {
    this.employeeRepository = employeeRepository;
    this.departmentRepository = departmentRepository;
  }

  @Override
  public CreateEmployeeUseCaseOutput execute(CreateEmployeeUseCaseInput input) {
    final String firstName = input.firstName();
    final String lastName = input.lastName();
    Optional<Department> optionalDepartment =
        departmentRepository.findByName(input.departmentName());
    if (optionalDepartment.isEmpty()) throw new IllegalArgumentException();
    final Department department = optionalDepartment.get();
    final Employee employee = new Employee();
    employee.setFirstName(firstName);
    employee.setLastName(lastName);
    employee.setDepartment(department);
    final Employee savedEmployee = employeeRepository.save(employee);
    return new CreateEmployeeUseCaseOutput(buildCreateEmployeeDto(savedEmployee));
  }

  private static CreateEmployeeDto buildCreateEmployeeDto(final Employee employee) {
    return new CreateEmployeeDto(
        employee.getId(),
        employee.getFirstName(),
        employee.getLastName(),
        employee.getDepartment().getName());
  }
}
