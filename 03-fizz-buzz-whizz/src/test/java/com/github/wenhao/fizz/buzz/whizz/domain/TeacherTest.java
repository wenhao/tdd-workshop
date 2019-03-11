package com.github.wenhao.fizz.buzz.whizz.domain;

import com.github.wenhao.fizz.buzz.whizz.exception.IllegalWordsException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeacherTest {

    private Teacher teacher;

    @BeforeEach
    void setUp() {
        teacher = new Teacher();
    }

    @Test
    public void should_raise_exception_when_less_than_three_numbers() throws Exception {
        // when
        assertThrows(IllegalWordsException.class, () -> teacher.say(1, 2));
    }

    @Test
    public void should_raise_exception_when_greater_than_three_numbers() throws Exception {
        // when
        assertThrows(IllegalWordsException.class, () -> teacher.say(1, 2, 3, 4));
    }

    @Test
    public void should_raise_exception_when_has_same_number() throws Exception {
        // when
        assertThrows(IllegalWordsException.class, () -> teacher.say(1, 1, 2));
    }

    @Test
    public void should_raise_exception_when_number_bigger_than_ten() throws Exception {
        // when
        assertThrows(IllegalWordsException.class, () -> teacher.say(1, 11, 12));
    }
}