package com.github.wenhao.tdd.bank.repository;

import java.util.ArrayList;
import java.util.List;

import com.github.wenhao.tdd.bank.Customer;

public class Persistence
{

    private List<Customer> customers = new ArrayList<Customer>();

    public boolean isExist(String nickname)
    {
        for (Customer customer : customers) {
            if (customer.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    public void save(Customer customer)
    {
        customers.add(customer);
    }
}
