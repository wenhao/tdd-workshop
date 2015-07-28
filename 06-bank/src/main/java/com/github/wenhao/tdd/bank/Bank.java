package com.github.wenhao.tdd.bank;

import java.util.ArrayList;
import java.util.List;

import com.github.wenhao.tdd.bank.exception.DuplicateNicknameException;

public class Bank
{
    private List<Customer> customers = new ArrayList<Customer>();

    public Customer create(Customer customer) throws DuplicateNicknameException
    {
        if (isExist(customer.getNickname())) {
            throw new DuplicateNicknameException();
        }
        customers.add(customer);
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
