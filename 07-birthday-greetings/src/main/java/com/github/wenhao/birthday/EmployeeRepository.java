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
import com.google.common.io.Resources;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmployeeRepository {

    public List<Employee> getEmployees() {
        return readFile().stream()
                .map(this::toEmployee)
                .collect(toList());
    }

    private List<String> readFile() {
        URL resource = Resources.getResource("classpath:/employee.txt");
        try {
            return Resources.readLines(resource, Charset.forName("UTF-8"));
        } catch (IOException e) {
            return Lists.newArrayList();
        }
    }

    private Employee toEmployee(final String line) {
        String[] metas = line.split("，");
        LocalDate birthday = LocalDate.parse(metas[2], DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        return new Employee(metas[0], metas[1], birthday, metas[3]);
    }
}
