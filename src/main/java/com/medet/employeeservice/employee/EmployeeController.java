package com.medet.employeeservice.employee;

import com.medet.employeeservice.employee.usecases.createemployee.CreateEmployeeDto;
import com.medet.employeeservice.employee.usecases.createemployee.CreateEmployeeUseCaseInput;
import com.medet.employeeservice.employee.usecases.createemployee.CreateEmployeeUseCaseOutput;
import com.medet.employeeservice.employee.usecases.deleteemployee.DeleteEmployeeVoidUseCaseInput;
import com.medet.employeeservice.employee.usecases.retrieveemployee.RetrieveEmployeeDto;
import com.medet.employeeservice.employee.usecases.retrieveemployee.RetrieveEmployeeUseCaseInput;
import com.medet.employeeservice.employee.usecases.retrieveemployee.RetrieveEmployeeUseCaseOutput;
import com.medet.employeeservice.usecase.UseCase;
import com.medet.employeeservice.usecase.VoidUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
  private final UseCase<RetrieveEmployeeUseCaseInput, RetrieveEmployeeUseCaseOutput>
      retrieveEmployeeUseCase;
  private final UseCase<CreateEmployeeUseCaseInput, CreateEmployeeUseCaseOutput>
      createEmployeeUseCase;
  private final VoidUseCase<DeleteEmployeeVoidUseCaseInput> deleteEmployeeVoidUseCase;

  @GetMapping("/{id}")
  ResponseEntity<RetrieveEmployeeDto> getEmployee(@PathVariable UUID id) {
    final RetrieveEmployeeUseCaseOutput output =
        retrieveEmployeeUseCase.execute(new RetrieveEmployeeUseCaseInput(id));
    return new ResponseEntity<>(output.retrieveEmployeeDto(), HttpStatus.OK);
  }

  @PostMapping
  ResponseEntity<CreateEmployeeDto> createEmployee(
      @RequestBody CreateEmployeeDto createEmployeeDto) {
    CreateEmployeeUseCaseOutput output =
        createEmployeeUseCase.execute(
            new CreateEmployeeUseCaseInput(
                createEmployeeDto.firstName(),
                createEmployeeDto.lastName(),
                createEmployeeDto.departmentName()));
    return new ResponseEntity<>(output.createEmployeeDto(), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
    deleteEmployeeVoidUseCase.execute(new DeleteEmployeeVoidUseCaseInput(id));
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
