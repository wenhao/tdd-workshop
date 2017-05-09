package com.github.wenhao.tdd.bank.message;

import static java.lang.String.format;

import com.github.wenhao.tdd.bank.Customer;

public class PremiumCustomerMessage
{
    private final Customer customer;

    public PremiumCustomerMessage(Customer customer)
    {
        this.customer = customer;
    }

    public void send(MessageGateway messageGateway)
    {
        messageGateway.send("manager@thebank.com", format("%s is now a premium customer", customer.getNickname()));
    }
}
