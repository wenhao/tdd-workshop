package com.github.wenhao.birthday;

import java.time.LocalDate;

public class Employee {

    private String fistName;
    private String lastName;
    private LocalDate birthday;
    private String email;

    public Employee(final String fistName, final String lastName, final LocalDate birthday, final String email) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
    }

    public LocalDate getBirthDay() {
        return this.birthday;
    }
}
