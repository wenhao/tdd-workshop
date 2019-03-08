package com.github.wenhao.birthday;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class EmployeeFinderTest {

    @Test
    public void should_find_all_employees_by_birthday_date() {
        // given
        final Date today = new Date();

        // when
        EmployeeFinder employeeFinder = new EmployeeFinder();
        List<Employee> employees = employeeFinder.findAll(today);

        // then
        assertThat(employees).isNotEmpty();
    }
}
