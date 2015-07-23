package com.github.wenhao.tdd.bank.repository;

import static java.util.Arrays.asList;

import java.util.List;

import com.github.wenhao.tdd.bank.Customer;

public class Persistence
{

    public boolean isExist(String nickname)
    {
        List<Customer> customers = asList(new Customer().withNickname("existed2nickname"));

        for (Customer customer : customers) {
            if (customer.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }
}
