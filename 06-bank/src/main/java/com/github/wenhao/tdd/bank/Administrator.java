package com.github.wenhao.tdd.bank;

import com.github.wenhao.tdd.bank.exception.DuplicateNicknameException;
import com.github.wenhao.tdd.bank.exception.InvalidNicknameException;
import com.github.wenhao.tdd.bank.repository.Persistence;

public class Administrator
{
    private Persistence persistence;

    public Administrator(Persistence persistence)
    {
        this.persistence = persistence;
    }

    public Customer create(Customer customer) throws InvalidNicknameException, DuplicateNicknameException
    {
        if (!customer.getNickname().matches("([a-z0-9])+")) {
            throw new InvalidNicknameException();
        }
        if (persistence.isExist(customer.getNickname())) {
            throw new DuplicateNicknameException();
        }
        return customer;
    }
}
