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

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeFinderTest {

    @InjectMocks
    private EmployeeFinder employeeFinder;
    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void should_find_all_employees_by_birthday_date() {
        // given
        final LocalDate date = LocalDate.of(2019, 10, 8);
        Employee john = new Employee("Doe", "John", LocalDate.of(1982, 10, 8), "john.doe@foobar.com");
        Employee mary = new Employee("Ann", "Mary", LocalDate.of(1975, 9, 11), "mary.ann@foobar.com");
        List<Employee> employees = Lists.newArrayList(john, mary);

        // when
        when(employeeRepository.getEmployees()).thenReturn(employees);
        List<Employee> birthdayEmployees = employeeFinder.find(date);

        // then
        assertThat(birthdayEmployees.size()).isEqualTo(1);
        assertThat(birthdayEmployees.contains(mary)).isFalse();
    }

    @Test
    public void should_find_all_employees_include_leap_year_birthday() {
        // given
        final LocalDate date = LocalDate.of(2019, 2, 28);
        Employee john = new Employee("Doe", "John", LocalDate.of(2000, 2, 29), "john.doe@foobar.com");
        List<Employee> employees = Lists.newArrayList(john);

        // when
        when(employeeRepository.getEmployees()).thenReturn(employees);
        List<Employee> birthdayEmployees = employeeFinder.find(date);

        // then
        assertThat(birthdayEmployees.size()).isEqualTo(1);
    }
}
