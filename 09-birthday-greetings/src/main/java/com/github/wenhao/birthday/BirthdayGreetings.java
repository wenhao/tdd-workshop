package com.github.wenhao.birthday;

import java.time.LocalDate;

public class BirthdayGreetings {
    private final EmailService emailService;
    private final EmployeeFinder employeeFinder;

    public BirthdayGreetings(final EmployeeFinder employeeFinder, final EmailService emailService) {
        this.emailService = emailService;
        this.employeeFinder = employeeFinder;
    }

    public void sendGreetings(final LocalDate date) {
        employeeFinder.findAll(date).stream()
                .map(this::toEmail)
                .forEach(emailService::send);
    }

    private Email toEmail(final Employee employee) {
        return new Email("Happy birthday!", String.format("Happy birthday, dear %s!", employee.getLastName()));
    }
}
