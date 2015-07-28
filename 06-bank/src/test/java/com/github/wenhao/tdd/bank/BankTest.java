package com.github.wenhao.tdd.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.joda.time.DateTime.now;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.wenhao.tdd.bank.exception.DuplicateNicknameException;

public class BankTest
{

    private Bank bank;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp()
    {
        this.bank = new Bank();
    }

    @Test
    public void should_add_customer_with_valid_customer_information() throws DuplicateNicknameException
    {
        // given
        Customer jack = new Customer("jack", now());

        // when
        Customer customer = this.bank.create(jack);

        // then
        assertThat(customer.getNickname()).isEqualTo("jack");
    }

    @Test
    public void should_raise_error_if_nickname_already_existed() throws DuplicateNicknameException
    {
        thrown.expect(DuplicateNicknameException.class);

        // given
        this.bank.create(new Customer("jack", now()));

        // when
        this.bank.create(new Customer("jack", now()));
    }
}
