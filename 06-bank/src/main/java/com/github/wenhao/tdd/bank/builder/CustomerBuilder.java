package com.github.wenhao.tdd.bank.builder;

import org.joda.time.DateTime;

import com.github.wenhao.tdd.bank.Customer;

public class CustomerBuilder
{
    private String nickname;
    private DateTime dateOfBirth;

    public CustomerBuilder withNickname(String nickname)
    {
        this.nickname = nickname;
        return this;
    }

    public Customer createCustomer()
    {
        return new Customer(nickname, dateOfBirth);
    }

    public CustomerBuilder withDateOfBirth(DateTime dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
}
