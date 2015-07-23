package com.github.wenhao.tdd.bank.validator;


import com.github.wenhao.tdd.bank.exception.CustomerException;

public interface Validator
{
    void validate(String nickname) throws CustomerException;
}
