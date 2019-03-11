package com.github.wenhao.fizz.buzz.whizz;

import com.github.wenhao.fizz.buzz.whizz.domain.Student;
import com.github.wenhao.fizz.buzz.whizz.domain.Teacher;
import com.github.wenhao.fizz.buzz.whizz.factory.HandlerFactory;
import com.github.wenhao.fizz.buzz.whizz.handler.BaseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FizzBuzzWhizzGameTest {
    private FizzBuzzWhizzGame fizzBuzzWhizzGame;

    @BeforeEach
    public void setUp() throws Exception {
        Teacher teacher = new Teacher();
        teacher.say(3, 5, 7);

        BaseHandler handler = HandlerFactory.build();

        Student student = new Student(3, handler);

        fizzBuzzWhizzGame = new FizzBuzzWhizzGame();
        fizzBuzzWhizzGame.setTeacher(teacher);
        fizzBuzzWhizzGame.setStudents(Arrays.asList(student));
    }

    @Test
    public void should_be_able_to_count() throws Exception {
        fizzBuzzWhizzGame.countOff();
    }
}
