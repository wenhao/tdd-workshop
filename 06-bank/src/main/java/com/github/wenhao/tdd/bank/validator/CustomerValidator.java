package com.github.wenhao.tdd.bank.validator;

import java.util.List;

import com.github.wenhao.tdd.bank.Customer;
import com.github.wenhao.tdd.bank.exception.CustomerException;

public class CustomerValidator
{
    private List<Validator> validators;

    public CustomerValidator(List<Validator> validators)
    {
        this.validators = validators;
    }

    public void validate(Customer customer) throws CustomerException
    {
        for (Validator validator : validators) {
            validator.validate(customer);
        }
    }
}
