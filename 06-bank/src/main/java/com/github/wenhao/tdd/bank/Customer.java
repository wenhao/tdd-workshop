package com.github.wenhao.tdd.bank;

import org.joda.time.DateTime;

import com.github.wenhao.tdd.bank.exception.BalanceNotEnoughException;
import com.github.wenhao.tdd.bank.exception.AmountNotPositiveException;

public class Customer
{
    private static final String VALID_CHARACTERS = "([a-z0-9])+";
    private String nickname;
    private DateTime dateOfBirth;
    private Double balance;

    public Customer(String nickname, DateTime dateOfBirth)
    {
        validate(nickname, dateOfBirth);
        this.nickname = nickname;
        this.dateOfBirth = dateOfBirth;
        this.balance = 0d;
    }

    public String getNickname()
    {
        return nickname;
    }

    private void validate(String nickname, DateTime dateOfBirth)
    {
        if (!nickname.matches(VALID_CHARACTERS) || dateOfBirth == null) {
            throw new IllegalArgumentException();
        }
    }

    public Double getBalance()
    {
        return balance;
    }

    public void deposit(Double amount) throws AmountNotPositiveException
    {
        shouldRaiseErrorIfNotPositiveAmount(amount);
        this.balance += amount;
    }

    public void withdraw(Double amount) throws BalanceNotEnoughException, AmountNotPositiveException
    {
        if (this.balance < amount) {
            throw new BalanceNotEnoughException();
        }
        shouldRaiseErrorIfNotPositiveAmount(amount);
        this.balance -= amount;
    }

    private void shouldRaiseErrorIfNotPositiveAmount(Double amount) throws AmountNotPositiveException
    {
        if (amount <= 0) {
            throw new AmountNotPositiveException();
        }
    }
}
