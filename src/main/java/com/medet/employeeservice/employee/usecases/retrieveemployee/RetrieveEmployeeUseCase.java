package com.medet.employeeservice.employee.usecases.retrieveemployee;

import com.medet.employeeservice.employee.Employee;
import com.medet.employeeservice.employee.EmployeeRepository;
import com.medet.employeeservice.usecase.UseCase;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RetrieveEmployeeUseCase
    implements UseCase<RetrieveEmployeeUseCaseInput, RetrieveEmployeeUseCaseOutput> {
  private final EmployeeRepository employeeRepository;

  public RetrieveEmployeeUseCase(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public RetrieveEmployeeUseCaseOutput execute(final RetrieveEmployeeUseCaseInput input) {
    Optional<Employee> optionalEmployee = employeeRepository.findById(input.id());
    if (optionalEmployee.isEmpty()) throw new EntityNotFoundException();
    Employee employee = optionalEmployee.get();
    return new RetrieveEmployeeUseCaseOutput(
        new RetrieveEmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getDepartment().getName()));
  }
}
