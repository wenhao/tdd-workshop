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
