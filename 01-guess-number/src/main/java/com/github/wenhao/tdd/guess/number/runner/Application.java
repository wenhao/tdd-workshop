package com.github.wenhao.tdd.guess.number.runner;

import com.github.wenhao.tdd.guess.number.config.GameModule;
import com.github.wenhao.tdd.guess.number.controller.GameController;
import com.google.inject.Guice;
import com.google.inject.Injector;

public final class Application
{
    private Application()
    {
    }

    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new GameModule());
        GameController gameController = injector.getInstance(GameController.class);

        gameController.play();
    }
}
