package com.github.wenhao.tdd.bank.builder;

import com.github.wenhao.tdd.bank.Customer;

public class CustomerBuilder
{
    private String nickname;

    public CustomerBuilder withNickname(String nickname)
    {
        this.nickname = nickname;
        return this;
    }

    public Customer createCustomer()
    {
        return new Customer(nickname);
    }
}