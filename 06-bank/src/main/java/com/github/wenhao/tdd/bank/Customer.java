package com.github.wenhao.tdd.bank;

import org.joda.time.DateTime;

public class Customer
{
    private String nickname;
    private DateTime dateOfBirth;

    public Customer(String nickname, DateTime dateOfBirth)
    {
        this.nickname = nickname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getNickname()
    {
        return nickname;
    }

    public DateTime getDateOfBirth()
    {
        return dateOfBirth;
    }
}
