package com.github.wenhao.birthday;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFinder {

    private final EmployeeRepository employeeRepository;

    public EmployeeFinder(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll(final LocalDate date) {
        List<Employee> findEmployees = new ArrayList<>();
        List<Employee> employees = this.employeeRepository.getEmployees();
        if (date.getMonth().equals(Month.FEBRUARY) && date.getDayOfMonth() == 28) {
            List<Employee> leapEmployees = employees.stream()
                    .filter(employee -> employee.getBirthDay().getMonth().equals(date.getMonth()) &&
                            employee.getBirthDay().getDayOfMonth() == 29 && employee.getBirthDay().isLeapYear())
                    .collect(Collectors.toList());
            findEmployees.addAll(leapEmployees);
        }
        List<Employee> searchEmployees = employees.stream()
                .filter(employee -> employee.getBirthDay().getMonth().equals(date.getMonth()) &&
                        employee.getBirthDay().getDayOfYear() == date.getDayOfYear())
                .collect(Collectors.toList());
        findEmployees.addAll(searchEmployees);
        return findEmployees;
    }
}
