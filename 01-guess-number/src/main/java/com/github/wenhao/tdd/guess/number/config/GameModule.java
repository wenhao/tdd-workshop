package com.github.wenhao.tdd.guess.number.config;

import com.github.wenhao.tdd.guess.number.command.ConsoleInputCommand;
import com.github.wenhao.tdd.guess.number.command.InputCommand;
import com.github.wenhao.tdd.guess.number.generator.AnswerGenerator;
import com.github.wenhao.tdd.guess.number.generator.RandomIntGenerator;
import com.github.wenhao.tdd.guess.number.validator.AnswerValidator;
import com.github.wenhao.tdd.guess.number.view.ConsoleGameView;
import com.github.wenhao.tdd.guess.number.view.GameView;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import static java.nio.charset.Charset.forName;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class GameModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(InputCommand.class).to(ConsoleInputCommand.class).in(Singleton.class);
        bind(GameView.class).to(ConsoleGameView.class).in(Singleton.class);
        bind(AnswerGenerator.class).in(Singleton.class);
        bind(RandomIntGenerator.class).in(Singleton.class);
        bind(Random.class).in(Singleton.class);
        bind(AnswerValidator.class).in(Singleton.class);
    }

    @Provides
    BufferedReader provideBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in, forName("UTF-8")));
    }
}
