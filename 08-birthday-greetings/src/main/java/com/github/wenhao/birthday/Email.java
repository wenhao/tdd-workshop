package com.github.wenhao.birthday;

public class Email {

    private String subject;
    private String content;

    public Email(final String subject, final String content) {
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getContent() {
        return this.content;
    }
}
