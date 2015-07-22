package com.github.wenhao.tdd.bank;

public class Customer
{
    private String nickname;

    public String getNickname()
    {
        return nickname;
    }

    public Customer withNickname(String nickname)
    {
        this.nickname = nickname;
        return this;
    }
}
