package com.github.wenhao.tdd.bank;

import org.joda.time.DateTime;

public class Customer
{
    private static final String VALID_CHARACTERS = "([a-z0-9])+";
    private String nickname;
    private DateTime dateOfBirth;

    public Customer(String nickname, DateTime dateOfBirth)
    {
        validate(nickname, dateOfBirth);
        this.nickname = nickname;
        this.dateOfBirth = dateOfBirth;
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

}
