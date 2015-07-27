package com.github.wenhao.tdd.bank.validator;

import com.github.wenhao.tdd.bank.Customer;
import com.github.wenhao.tdd.bank.exception.IllegalCharacterException;

public class SpecialCharacterValidator extends Validator
{

    public void validate(Customer customer) throws IllegalCharacterException
    {
        if (!customer.getNickname().matches("([a-z0-9])+")) {
            throw new IllegalCharacterException();
        }
    }
}
