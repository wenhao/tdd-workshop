package com.github.wenhao.tdd.bank.validator;


import com.github.wenhao.tdd.bank.exception.CustomerException;

public abstract class Validator
{
    abstract void validate(String nickname) throws CustomerException;
}
