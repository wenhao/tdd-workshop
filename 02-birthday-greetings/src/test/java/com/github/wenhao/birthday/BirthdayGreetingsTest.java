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

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BirthdayGreetingsTest {

    @InjectMocks
    private BirthdayGreetings birthDayGreetings;
    @Mock
    private EmailService emailService;
    @Mock
    private EmployeeFinder employeeFinder;

    @Test
    public void should_send_birthday_greetings_base_on_given_date() {
        // given
        final LocalDate today = LocalDate.of(2019, 3, 11);
        Employee john = new Employee("Doe", "John", LocalDate.of(1982, 3, 11), "john.doe@foobar.com");
        List<Employee> employees = Lists.newArrayList(john);

        // when
        when(employeeFinder.find(today)).thenReturn(employees);
        birthDayGreetings.sendGreetings(today);

        // then
        then(emailService).should().send(argThat(email -> email.getSubject().equals("Happy birthday!") && email.getContent().equals("Happy birthday, dear John!")));
    }
}
