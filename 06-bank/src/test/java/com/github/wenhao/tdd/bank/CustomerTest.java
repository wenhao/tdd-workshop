package com.github.wenhao.tdd.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.joda.time.DateTime.now;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
}
