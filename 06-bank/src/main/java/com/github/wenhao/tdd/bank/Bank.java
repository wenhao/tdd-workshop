package com.github.wenhao.tdd.bank;

import java.util.ArrayList;
import java.util.List;

import com.github.wenhao.tdd.bank.exception.DuplicateNicknameException;
import com.github.wenhao.tdd.bank.message.MessageGateway;
import com.github.wenhao.tdd.bank.message.WelcomeMessage;

public class Bank
{
    private final MessageGateway messageGateway;
    private List<Customer> customers = new ArrayList<Customer>();

    public Bank(MessageGateway messageGateway)
    {
        this.messageGateway = messageGateway;
    }

    public Customer create(Customer customer) throws DuplicateNicknameException
    {
        if (isExist(customer.getNickname())) {
            throw new DuplicateNicknameException();
        }
        customers.add(customer);
        new WelcomeMessage(customer).send(this.messageGateway);
        return customer;
    }

    private boolean isExist(String nickName)
    {
        for (Customer customer : customers) {
            if (customer.getNickname().equals(nickName)) {
                return true;
            }
        }
        return false;
    }

}
