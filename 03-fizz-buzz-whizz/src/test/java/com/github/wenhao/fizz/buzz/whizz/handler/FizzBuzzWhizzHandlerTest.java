package com.github.wenhao.fizz.buzz.whizz.handler;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_BUZZ_WHIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import com.github.wenhao.fizz.buzz.whizz.domain.Words;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FizzBuzzWhizzHandlerTest {

    private FizzBuzzWhizzHandler fizzBuzzWhizzHandler;
    private Words words;

    @BeforeEach
    public void setUp() throws Exception {
        words = mock(Words.class);
        when(words.getFirst()).thenReturn(3);
        when(words.getSecond()).thenReturn(5);
        when(words.getThird()).thenReturn(7);
        fizzBuzzWhizzHandler = new FizzBuzzWhizzHandler(new FizzHandler(new BuzzHandler(new WhizzHandler(null))));
    }

    @Test
    public void should_be_able_to_return_fizz_buzz_whizz_when_student_count_is_multiple_of_3_and_5_and_7() throws Exception {
        // when
        String result = fizzBuzzWhizzHandler.handle(105, words);

        // then
        assertThat(result).isEqualTo(FIZZ_BUZZ_WHIZZ);
    }

    @Test
    public void should_next_handler_process() throws Exception {
        // when
        String fizz = fizzBuzzWhizzHandler.handle(3, words);
        String buzz = fizzBuzzWhizzHandler.handle(5, words);
        String whizz = fizzBuzzWhizzHandler.handle(7, words);

        // then
        assertThat(fizz).isEqualTo(FIZZ);
        assertThat(buzz).isEqualTo(BUZZ);
        assertThat(whizz).isEqualTo(WHIZZ);
    }
}