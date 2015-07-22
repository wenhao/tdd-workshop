package com.github.wenhao.tdd.bank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.github.wenhao.tdd.bank.exception.InvalidNicknameException;

public class AdministratorTest
{

    private Administrator administrator;

    @Before
    public void setUp() throws Exception
    {

        this.administrator = new Administrator();
    }

    @Test
    public void should_add_customer_with_valid_customer_information() throws InvalidNicknameException
    {
        // given
        Customer customerToBeAdd = new Customer().withNickname("jack");

        // when
        Customer customer = this.administrator.create(customerToBeAdd);

        // then
        assertThat(customer.getNickname()).isEqualTo("jack");
    }

    @Test(expected = InvalidNicknameException.class)
    public void should_raise_error_if_nickname_has_uppercase_letter() throws InvalidNicknameException
    {
        // given
        Customer customerToBeAdd = new Customer().withNickname("UPPER_jack");

        // when
        this.administrator.create(customerToBeAdd);
    }

    @Test
    public void should_raise_error_if_nickname_has_digits()
    {
        // given

        // when

        // then
    }
}
