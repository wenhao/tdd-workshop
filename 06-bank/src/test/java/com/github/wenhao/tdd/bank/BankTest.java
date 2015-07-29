package com.github.wenhao.tdd.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.joda.time.DateTime.now;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.wenhao.tdd.bank.exception.DuplicateNicknameException;
import com.github.wenhao.tdd.bank.stub.MessageGatewayStub;

public class BankTest
{

    private Bank bank;

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private MessageGatewayStub messageGatewayStub;
    private Customer customer;

    @Before
    public void setUp()
    {
        messageGatewayStub = new MessageGatewayStub();
        customer = new Customer("jack", now(), messageGatewayStub);
        this.bank = new Bank(messageGatewayStub);
    }

    @Test
    public void should_add_customer_with_valid_customer_information() throws DuplicateNicknameException
    {
        // given

        // when
        Customer customer = this.bank.create(this.customer);

        // then
        assertThat(customer.getNickname()).isEqualTo("jack");
        assertThat(messageGatewayStub.getRecipient()).isEqualTo("jack@thebank.com");
        assertThat(messageGatewayStub.getContent()).isEqualTo("Dear jack, Welcome to the Bank");
    }

    @Test
    public void should_raise_error_if_nickname_already_existed() throws DuplicateNicknameException
    {
        thrown.expect(DuplicateNicknameException.class);

        // given
        this.bank.create(customer);

        // when
        this.bank.create(customer);
    }
}
