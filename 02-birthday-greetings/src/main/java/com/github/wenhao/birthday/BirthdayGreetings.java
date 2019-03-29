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

public class BirthdayGreetings {
    private final EmailService emailService;
    private final EmployeeFinder employeeFinder;

    public BirthdayGreetings(final EmployeeFinder employeeFinder, final EmailService emailService) {
        this.emailService = emailService;
        this.employeeFinder = employeeFinder;
    }

    public void sendGreetings(final LocalDate date) {
        employeeFinder.find(date).stream()
                .map(this::toEmail)
                .forEach(emailService::send);
    }

    private Email toEmail(final Employee employee) {
        return new Email("Happy birthday!", String.format("Happy birthday, dear %s!", employee.getLastName()));
    }
}
