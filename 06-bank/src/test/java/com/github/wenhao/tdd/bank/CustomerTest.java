package com.github.wenhao.tdd.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.joda.time.DateTime.now;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.wenhao.tdd.bank.exception.BalanceNotEnoughException;
import com.github.wenhao.tdd.bank.exception.AmountNotPositiveException;

public class CustomerTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_add_customer_with_valid_customer_information()
    {
        // when
        Customer customer = new Customer("jack", now());

        // then
        assertThat(customer.getNickname()).isEqualTo("jack");
    }

    @Test
    public void should_raise_error_if_nickname_has_uppercase_letter()
    {
        thrown.expect(IllegalArgumentException.class);

        // when
        new Customer("UPPER_jack", now());
    }

    @Test
    public void should_raise_error_if_nickname_has_special_character()
    {
        thrown.expect(IllegalArgumentException.class);

        // when
        new Customer("@#$123", now());
    }

    @Test
    public void should_raise_error_if_customer_did_not_have_date_of_birth()
    {
        thrown.expect(IllegalArgumentException.class);

        // when
        new Customer("jack", null);
    }

    @Test
    public void should_deposit_money_from_customer_account() throws AmountNotPositiveException
    {
        // given
        Customer customer = new Customer("jack", now());

        // when
        customer.deposit(50d);

        // then
        assertThat(customer.getBalance()).isEqualTo(50d);
    }

    @Test
    public void should_raise_error_if_deposit_amount_is_not_positive_number() throws AmountNotPositiveException
    {
        thrown.expect(AmountNotPositiveException.class);

        // given
        Customer customer = new Customer("jack", now());

        // when
        customer.deposit(-1d);
    }

    @Test
    public void should_withdraw_money_from_customer_account() throws AmountNotPositiveException, BalanceNotEnoughException
    {
        // given
        Customer customer = new Customer("jack", now());

        // when
        customer.deposit(100d);
        customer.withdraw(50d);

        // then
        assertThat(customer.getBalance()).isEqualTo(50d);
    }

    @Test
    public void should_withdraw_all_the_money() throws AmountNotPositiveException, BalanceNotEnoughException
    {
        // given
        Customer customer = new Customer("jack", now());

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

        // given
        Customer customer = new Customer("jack", now());

        // when
        customer.deposit(100d);
        customer.withdraw(200d);
    }

    @Test
    public void should_raise_error_if_withdraw_amount_is_not_positive_number() throws AmountNotPositiveException, BalanceNotEnoughException
    {
        thrown.expect(AmountNotPositiveException.class);

        // given
        Customer customer = new Customer("jack", now());

        // when
        customer.deposit(100d);
        customer.withdraw(-1d);
    }
}
