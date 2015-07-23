package com.github.wenhao.tdd.bank.validator;

import java.util.Arrays;
import java.util.List;

import com.github.wenhao.tdd.bank.exception.CustomerException;
import com.github.wenhao.tdd.bank.repository.Persistence;

public class CustomerValidator
{

    private final List<Validator> validators;

    public CustomerValidator()
    {
        validators = Arrays.asList(new DuplicateValidator(new Persistence()), new SpecialCharacterValidator());
    }

    public void validate(String nickname) throws CustomerException
    {
        for (Validator validator : validators) {
            validator.validate(nickname);
        }

    }
}
