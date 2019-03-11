package com.github.wenhao.birthday;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.then;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BirthdayGreetingsTest {

    @InjectMocks
    private BirthdayGreetings birthDayGreetings;
    @Mock
    private EmailService emailService;
    @Mock
    private EmployeeFinder employeeFinder;

    @Test
    void should_send_birthday_greetings_base_on_given_date() {
        // given
        final LocalDate today = LocalDate.of(2019, 3, 11);
        Employee john = new Employee("Doe", "John", LocalDate.of(1982, 3, 11), "john.doe@foobar.com");
        List<Employee> employees = Lists.newArrayList(john);

        // when
        when(employeeFinder.findAll(today)).thenReturn(employees);
        birthDayGreetings.sendGreetings(today);

        // then
        then(emailService).should().send(argThat(email -> email.getSubject().equals("Happy birthday!") && email.getContent().equals("Happy birthday, dear John!")));
    }
}
