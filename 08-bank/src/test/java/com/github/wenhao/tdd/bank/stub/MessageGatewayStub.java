package com.github.wenhao.tdd.bank.stub;

import com.github.wenhao.tdd.bank.message.MessageGateway;

public class MessageGatewayStub extends MessageGateway
{
    private String recipient;
    private String content;

    public String getRecipient()
    {
        return recipient;
    }

    public String getContent()
    {
        return content;
    }

    @Override
    public void send(String recipient, String content)
    {
        this.recipient = recipient;
        this.content = content;
    }
}
