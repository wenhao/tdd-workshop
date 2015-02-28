package com.github.wenhao.tdd.pos.parser;

public interface Parser<T>
{
    T parse(String line);
}
