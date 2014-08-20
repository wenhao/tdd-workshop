package com.github.wenhao.fizz.buzz.whizz.handler;

public class DefaultHandler extends BaseHandler
{
    public DefaultHandler()
    {
        super(null);
    }

    @Override
    public String handle(Integer number)
    {
        return number.toString();
    }
}
