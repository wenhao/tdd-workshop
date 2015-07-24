package com.github.wenhao.tdd.bank.builder;

import java.util.ArrayList;
import java.util.List;

import com.github.wenhao.tdd.bank.validator.CustomerValidator;
import com.github.wenhao.tdd.bank.validator.Validator;

public class CustomerValidatorBuilder
{
    private List<Validator> validators = new ArrayList<Validator>();

    public CustomerValidatorBuilder addValidator(Validator validator)
    {
        this.validators.add(validator);
        return this;
    }

    public CustomerValidator createCustomerValidator()
    {
        return new CustomerValidator(validators);
    }
}