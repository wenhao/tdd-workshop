/*
 * Copyright © 2019, Wen Hao <wenhao@126.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
