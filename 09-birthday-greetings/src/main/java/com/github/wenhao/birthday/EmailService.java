package com.github.wenhao.birthday;

public class EmailService {

    public void send(final Email email) {
        System.out.println(email.getSubject());
        System.out.println(email.getContent());
    }
}
