package com.github.wenhao.birthday;

import com.google.common.collect.Lists;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class EmployeeFinderTest {

    @Test
    public void should_find_all_employees_by_birthday_date() {
        // given
        final LocalDate date =  LocalDate.of(2019, 10, 8);
        Employee john = new Employee("Doe", "John", LocalDate.of(1982, 10, 8), "john.doe@foobar.com");
        Employee mary = new Employee("Ann", "Mary", LocalDate.of(1975, 9, 11), "mary.ann@foobar.com");
        List<Employee> employees = Lists.newArrayList(john, mary);

        // when
        EmployeeFinder employeeFinder = new EmployeeFinder(employees);
        List<Employee> birthdayEmployees = employeeFinder.findAll(date);

        // then
        assertThat(birthdayEmployees.size()).isEqualTo(1);
        assertThat(birthdayEmployees.contains(mary)).isFalse();
    }
}
