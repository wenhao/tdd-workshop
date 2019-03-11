package com.github.wenhao.fizz.buzz.whizz.handler;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_WHIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import com.github.wenhao.fizz.buzz.whizz.domain.Words;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FizzWhizzHandlerTest {

    private FizzWhizzHandler fizzWhizzHandler;
    private Words words;

    @BeforeEach
    public void setUp() throws Exception {
        words = mock(Words.class);
        when(words.getFirst()).thenReturn(3);
        when(words.getSecond()).thenReturn(5);
        when(words.getThird()).thenReturn(7);
        fizzWhizzHandler = new FizzWhizzHandler(new FizzHandler(new BuzzHandler(new WhizzHandler(null))));
    }

    @Test
    public void should_be_able_to_return_fizz_whizz_when_student_count_is_multiple_of_3_and_7() throws Exception {
        // when
        String result = fizzWhizzHandler.handle(21, words);

        // then
        assertThat(result).isEqualTo(FIZZ_WHIZZ);
    }

    @Test
    public void should_next_handler_process() throws Exception {
        // when
        String fizz = fizzWhizzHandler.handle(3, words);
        String buzz = fizzWhizzHandler.handle(5, words);
        String whizz = fizzWhizzHandler.handle(7, words);

        // then
        assertThat(fizz).isEqualTo(FIZZ);
        assertThat(buzz).isEqualTo(BUZZ);
        assertThat(whizz).isEqualTo(WHIZZ);
    }
}