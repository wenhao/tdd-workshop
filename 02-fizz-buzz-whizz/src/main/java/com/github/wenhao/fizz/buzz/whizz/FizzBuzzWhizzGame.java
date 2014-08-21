package com.github.wenhao.fizz.buzz.whizz;

import com.github.wenhao.fizz.buzz.whizz.domain.Student;
import com.github.wenhao.fizz.buzz.whizz.domain.Teacher;

import java.util.List;

public class FizzBuzzWhizzGame
{

    private List<Student> students;
    private Teacher teacher;

    public void countOff()
    {
        for (Student student : students) {
            System.out.println(student.countOff(teacher.getWords()));
        }

    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

}

