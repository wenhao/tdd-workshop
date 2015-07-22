package com.github.wenhao.tdd.bank;

import com.github.wenhao.tdd.bank.exception.InvalidNicknameException;

public class Administrator
{
    public Customer create(Customer customer) throws InvalidNicknameException
    {
        for (byte letter : customer.getNickname().getBytes()) {
            if (Character.isUpperCase(letter)) {
                throw new InvalidNicknameException();
            }
        }

        return customer;
    }
}
