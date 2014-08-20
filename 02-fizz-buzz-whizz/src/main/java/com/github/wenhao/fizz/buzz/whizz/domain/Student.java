package com.github.wenhao.fizz.buzz.whizz.domain;

import com.github.wenhao.fizz.buzz.whizz.handler.BaseHandler;

public class Student
{
    private Integer position;
    private BaseHandler baseHandler;

    public Student(Integer position, BaseHandler baseHandler)
    {
        this.position = position;
        this.baseHandler = baseHandler;
    }

    public String countOff()
    {
        return baseHandler.handle(position);
    }
}
