package com.github.wenhao.tdd.bank;

import static java.lang.String.format;

import org.joda.time.DateTime;

import com.github.wenhao.tdd.bank.exception.AmountNotPositiveException;
import com.github.wenhao.tdd.bank.exception.BalanceNotEnoughException;
import com.github.wenhao.tdd.bank.message.MessageGateway;
import com.github.wenhao.tdd.bank.message.PremiumCustomerMessage;

public class Customer
{
    private static final String VALID_CHARACTERS = "([a-z0-9])+";
    private static final String EMAIL_TEMPLATE = "%s@thebank.com";
    private static final int PREMIUM_BALANCE_MINIMUM = 40000;
    private MessageGateway messageGateway;
    private String nickname;
    private DateTime dateOfBirth;
    private Double balance;

    public Customer(String nickname, DateTime dateOfBirth, MessageGateway messageGateway)
    {
        validate(nickname, dateOfBirth);
        this.nickname = nickname;
        this.dateOfBirth = dateOfBirth;
        this.messageGateway = messageGateway;
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
        if (meetPremiumCustomerCriteria()) {
            new PremiumCustomerMessage(this).send(this.messageGateway);
        }
    }

    private boolean meetPremiumCustomerCriteria()
    {
        return this.balance > PREMIUM_BALANCE_MINIMUM;
    }

    public void withdraw(Double amount) throws BalanceNotEnoughException, AmountNotPositiveException
    {
        if (balanceNotEnough(amount)) {
            throw new BalanceNotEnoughException();
        }
        shouldRaiseErrorIfNotPositiveAmount(amount);
        this.balance -= amount;
    }

    private boolean balanceNotEnough(Double amount)
    {
        return this.balance < amount;
    }

    private void shouldRaiseErrorIfNotPositiveAmount(Double amount) throws AmountNotPositiveException
    {
        if (amount <= 0) {
            throw new AmountNotPositiveException();
        }
    }

    public String getEmail()
    {
        return format(EMAIL_TEMPLATE, getNickname());
    }
}
