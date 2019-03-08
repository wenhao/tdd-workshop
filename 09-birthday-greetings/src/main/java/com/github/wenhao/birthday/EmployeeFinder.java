package com.github.wenhao.birthday;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFinder {

    private List<Employee> employees;

    public EmployeeFinder(final List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> findAll(final LocalDate date) {
        List<Employee> findEmployees = new ArrayList<>();
        if (date.getMonth().equals(Month.FEBRUARY) && date.getDayOfMonth() == 28) {
            List<Employee> leapEmployees = this.employees.stream()
                    .filter(employee -> employee.getBirthDay().getMonth().equals(date.getMonth()) &&
                            employee.getBirthDay().getDayOfMonth() == 29 && employee.getBirthDay().isLeapYear())
                    .collect(Collectors.toList());
            findEmployees.addAll(leapEmployees);
        }
        List<Employee> searchEmployees = this.employees.stream()
                .filter(employee -> employee.getBirthDay().getMonth().equals(date.getMonth()) &&
                        employee.getBirthDay().getDayOfYear() == date.getDayOfYear())
                .collect(Collectors.toList());
        findEmployees.addAll(searchEmployees);
        return findEmployees;
    }
}
