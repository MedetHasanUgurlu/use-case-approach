package com.medet.employeeservice.usecase;

@FunctionalInterface
public interface VoidUseCase<I extends UseCaseInput> {
  void execute(I input);
}
