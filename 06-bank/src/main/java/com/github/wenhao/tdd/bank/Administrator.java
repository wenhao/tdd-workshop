package com.github.wenhao.tdd.bank;

import com.github.wenhao.tdd.bank.exception.CustomerException;
import com.github.wenhao.tdd.bank.validator.CustomerValidator;

public class Administrator
{
    private CustomerValidator customerValidator;

    public Administrator(CustomerValidator customerValidator)
    {
        this.customerValidator = customerValidator;
    }

    public Customer create(Customer customer) throws CustomerException
    {
        customerValidator.validate(customer.getNickname());
        return customer;
    }

}
