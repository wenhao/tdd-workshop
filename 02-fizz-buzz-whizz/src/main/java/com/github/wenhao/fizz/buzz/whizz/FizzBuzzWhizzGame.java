package com.github.wenhao.fizz.buzz.whizz;

import com.github.wenhao.fizz.buzz.whizz.domain.Student;

import java.util.List;

public class FizzBuzzWhizzGame
{

    private List<Student> students;

    public void countOff()
    {
        for (Student student : students) {
            System.out.println(student.countOff());
        }

    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

}

