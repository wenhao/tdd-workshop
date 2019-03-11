package com.github.wenhao.fizz.buzz.whizz.handler;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import com.github.wenhao.fizz.buzz.whizz.domain.Words;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpecialFizzHandlerTest {

    private SpecialFizzHandler specialFizzHandler;
    private Words words;

    @BeforeEach
    public void setUp() throws Exception {
        words = mock(Words.class);
        when(words.getFirst()).thenReturn(3);
        when(words.getSecond()).thenReturn(5);
        specialFizzHandler = new SpecialFizzHandler(new BuzzHandler(null));
    }

    @Test
    public void should_be_able_to_return_fizz_when_student_count_contains_3() throws Exception {
        // when
        String result = specialFizzHandler.handle(35, words);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void should_next_handler_process() throws Exception {
        // when
        String result = specialFizzHandler.handle(5, words);

        // then
        assertThat(result).isEqualTo(BUZZ);
    }
}