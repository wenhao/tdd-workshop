package com.github.wenhao.tdd.bank.message;

import static java.lang.String.format;

import com.github.wenhao.tdd.bank.Customer;

public class WelcomeMessage
{
    private Customer customer;

    public WelcomeMessage(Customer customer)
    {
        this.customer = customer;
    }

    public void send(MessageGateway messageGateway)
    {
        messageGateway.send(customer.getEmail(), format("Dear %s, Welcome to the Bank", customer.getNickname()));
    }
}
