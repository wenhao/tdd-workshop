package com.github.wenhao.fizz.buzz.whizz.handler;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import com.github.wenhao.fizz.buzz.whizz.domain.Words;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuzzHandlerTest {

    private BuzzHandler buzzHandler;
    private Words words;

    @BeforeEach
    public void setUp() throws Exception {
        words = mock(Words.class);
        when(words.getFirst()).thenReturn(3);
        when(words.getSecond()).thenReturn(5);
        when(words.getThird()).thenReturn(7);
        buzzHandler = new BuzzHandler(new WhizzHandler(null));
    }

    @Test
    public void should_be_able_to_return_Buzz_when_student_count_is_multiple_of_5() throws Exception {
        // when
        String result = buzzHandler.handle(5, words);

        // then
        assertThat(result).isEqualTo(BUZZ);
    }

    @Test
    public void should_next_handler_process() throws Exception {
        // when
        String result = buzzHandler.handle(7, words);

        // then
        assertThat(result).isEqualTo(WHIZZ);
    }
}