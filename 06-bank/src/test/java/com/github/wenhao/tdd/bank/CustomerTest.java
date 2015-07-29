package com.github.wenhao.tdd.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.joda.time.DateTime.now;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.wenhao.tdd.bank.exception.BalanceNotEnoughException;
import com.github.wenhao.tdd.bank.exception.AmountNotPositiveException;
import com.github.wenhao.tdd.bank.stub.MessageGatewayStub;

public class CustomerTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private Customer customer;
    private MessageGatewayStub messageGatewayStub;

    @Before
    public void setUp() throws Exception
    {
        messageGatewayStub = new MessageGatewayStub();
        customer = new Customer("jack", now(), messageGatewayStub);
    }

    @Test
    public void should_add_customer_with_valid_customer_information()
    {
        // then
        assertThat(customer.getNickname()).isEqualTo("jack");
    }

    @Test
    public void should_raise_error_if_nickname_has_uppercase_letter()
    {
        thrown.expect(IllegalArgumentException.class);

        // when
        new Customer("UPPER_jack", now(), messageGatewayStub);
    }

    @Test
    public void should_raise_error_if_nickname_has_special_character()
    {
        thrown.expect(IllegalArgumentException.class);

        // when
        new Customer("@#$123", now(), messageGatewayStub);
    }

    @Test
    public void should_raise_error_if_customer_did_not_have_date_of_birth()
    {
        thrown.expect(IllegalArgumentException.class);

        // when
        new Customer("jack", null, messageGatewayStub);
    }

    @Test
    public void should_deposit_money_from_customer_account() throws AmountNotPositiveException
    {
        // when
        customer.deposit(50d);

        // then
        assertThat(customer.getBalance()).isEqualTo(50d);
    }

    @Test
    public void should_raise_error_if_deposit_amount_is_not_positive_number() throws AmountNotPositiveException
    {
        thrown.expect(AmountNotPositiveException.class);

        // when
        customer.deposit(-1d);
    }

    @Test
    public void should_withdraw_money_from_customer_account() throws AmountNotPositiveException, BalanceNotEnoughException
    {
        // when
        customer.deposit(100d);
        customer.withdraw(50d);

        // then
        assertThat(customer.getBalance()).isEqualTo(50d);
    }

    @Test
    public void should_withdraw_all_the_money() throws AmountNotPositiveException, BalanceNotEnoughException
    {
        // when
        customer.deposit(100d);
        customer.withdraw(100d);

        // then
        assertThat(customer.getBalance()).isEqualTo(0d);
    }

    @Test
    public void should_raise_error_if_overdraw() throws AmountNotPositiveException, BalanceNotEnoughException
    {
        thrown.expect(BalanceNotEnoughException.class);

        // when
        customer.deposit(100d);
        customer.withdraw(200d);
    }

    @Test
    public void should_raise_error_if_withdraw_amount_is_not_positive_number() throws AmountNotPositiveException, BalanceNotEnoughException
    {
        thrown.expect(AmountNotPositiveException.class);

        // when
        customer.deposit(100d);
        customer.withdraw(-1d);
    }

    @Test
    public void should_send_email_if_customer_balance_over_40000_when_deposit() throws AmountNotPositiveException
    {
        // when
        customer.deposit(40001d);

        // then
        assertThat(this.messageGatewayStub.getRecipient()).isEqualTo("manager@thebank.com");
        assertThat(this.messageGatewayStub.getContent()).isEqualTo("jack is now a premium customer");
    }
}
