package com.github.wenhao.fizz.buzz.whizz;

import com.github.wenhao.fizz.buzz.whizz.domain.Teacher;
import org.junit.Before;
import org.junit.Test;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzWhizzGameTest
{
    private FizzBuzzWhizzGame fizzBuzzWhizzGame;

    @Before
    public void setUp() throws Exception
    {
        Teacher teacher = new Teacher();
        teacher.say(3,  5,  7);
        fizzBuzzWhizzGame = new FizzBuzzWhizzGame(teacher);
    }

    @Test
    public void should_be_able_to_return_fizz_when_student_count_is_multiple_of_3() throws Exception
    {
        // when
        String result = fizzBuzzWhizzGame.countOff(3);

        // then
        assertThat(result, is(FIZZ));
    }
}
