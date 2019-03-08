package com.github.wenhao.birthday;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFinder {

    private List<Employee> employees;

    public EmployeeFinder(final List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> findAll(final LocalDate date) {
        return employees.stream()
                .filter(employee -> employee.getBirthDay().getMonth() == date.getMonth() &&
                        employee.getBirthDay().getDayOfYear() == date.getDayOfYear())
                .collect(Collectors.toList());
    }
}
