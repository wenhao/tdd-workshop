package com.github.wenhao.tdd.bank;

import com.github.wenhao.tdd.bank.exception.CustomerException;
import com.github.wenhao.tdd.bank.repository.Persistence;
import com.github.wenhao.tdd.bank.validator.CustomerValidator;

public class Administrator
{
    private CustomerValidator customerValidator;
    private Persistence persistence;

    public Administrator(CustomerValidator customerValidator, Persistence persistence)
    {
        this.customerValidator = customerValidator;
        this.persistence = persistence;
    }

    public Customer create(Customer customer) throws CustomerException
    {
        customerValidator.validate(customer.getNickname());
        persistence.save(customer);
        return customer;
    }

}
