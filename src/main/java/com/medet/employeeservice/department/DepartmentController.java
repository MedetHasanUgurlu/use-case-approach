package com.medet.employeeservice.department;

import com.medet.employeeservice.department.usecases.createdepartment.CreateDepartmentDto;
import com.medet.employeeservice.department.usecases.createdepartment.CreateDepartmentUseCaseInput;
import com.medet.employeeservice.department.usecases.createdepartment.CreateDepartmentUseCaseOutput;
import com.medet.employeeservice.department.usecases.retrievedepartment.RetrieveDepartmentDto;
import com.medet.employeeservice.department.usecases.retrievedepartment.RetrieveDepartmentUseCaseInput;
import com.medet.employeeservice.department.usecases.retrievedepartment.RetrieveDepartmentUseCaseOutput;
import com.medet.employeeservice.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
  private final UseCase<CreateDepartmentUseCaseInput, CreateDepartmentUseCaseOutput>
      createDepartmentUseCase;
  private final UseCase<RetrieveDepartmentUseCaseInput, RetrieveDepartmentUseCaseOutput>
      retrieveDepartmentUseCase;

  @PostMapping
  ResponseEntity<CreateDepartmentDto> addDepartment(
      @RequestBody final CreateDepartmentDto createDepartmentDto) {
    final var name = createDepartmentDto.name();
    final var description = createDepartmentDto.description();
    final var code = createDepartmentDto.code();
    final CreateDepartmentUseCaseOutput output =
        createDepartmentUseCase.execute(new CreateDepartmentUseCaseInput(name, description, code));
    return new ResponseEntity<>(output.createDepartmentDto(), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  ResponseEntity<RetrieveDepartmentDto> getDepartment(@PathVariable UUID id) {
    final RetrieveDepartmentUseCaseOutput output =
        retrieveDepartmentUseCase.execute(new RetrieveDepartmentUseCaseInput(id));
    return new ResponseEntity<>(output.retrieveDepartmentDto(), HttpStatus.OK);
  }
}
