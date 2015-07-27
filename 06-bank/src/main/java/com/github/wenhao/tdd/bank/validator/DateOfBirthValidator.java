package com.github.wenhao.tdd.bank.validator;

import com.github.wenhao.tdd.bank.Customer;
import com.github.wenhao.tdd.bank.exception.CustomerException;
import com.github.wenhao.tdd.bank.exception.DateOfBirthEmptyException;

public class DateOfBirthValidator extends Validator
{
    @Override
    void validate(Customer customer) throws CustomerException
    {
        if (customer.getDateOfBirth() == null) {
            throw new DateOfBirthEmptyException();
        }
    }
}
