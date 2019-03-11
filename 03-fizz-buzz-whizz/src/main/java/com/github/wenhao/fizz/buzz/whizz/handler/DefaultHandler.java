package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;

public class DefaultHandler extends BaseHandler {
    public DefaultHandler() {
        super(null);
    }

    @Override
    public String handle(Integer number, Words words) {
        return number.toString();
    }
}
