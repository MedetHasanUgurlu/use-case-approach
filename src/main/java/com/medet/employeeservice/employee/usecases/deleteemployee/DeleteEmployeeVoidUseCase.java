package com.medet.employeeservice.employee.usecases.deleteemployee;

import com.medet.employeeservice.employee.EmployeeRepository;
import com.medet.employeeservice.usecase.VoidUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmployeeVoidUseCase implements VoidUseCase<DeleteEmployeeVoidUseCaseInput> {
    private final EmployeeRepository employeeRepository;

    public DeleteEmployeeVoidUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
  public void execute(DeleteEmployeeVoidUseCaseInput input) {
        final var id = input.id();
        employeeRepository.deleteById(id);
    }

}
