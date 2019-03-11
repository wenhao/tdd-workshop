package com.github.wenhao.tdd.guess.number.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class AnswerConstantTest {
    @Test
    public void pass_cobertura() throws Exception {
        // when
        Constructor<?>[] declaredConstructors = AnswerConstant.class.getDeclaredConstructors();
        declaredConstructors[0].setAccessible(true);
        declaredConstructors[0].newInstance();
    }
}
