package com.github.wenhao.tdd.bank.message;

public abstract class MessageGateway
{
    public abstract void send(String recipient, String content);
}
