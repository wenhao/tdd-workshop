package com.github.wenhao.birthday;

import com.google.common.collect.Lists;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
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
        List<Employee> birthdayEmployees = employeeFinder.findAll(date);

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
        List<Employee> birthdayEmployees = employeeFinder.findAll(date);

        // then
        assertThat(birthdayEmployees.size()).isEqualTo(1);
    }
}
