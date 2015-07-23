package com.github.wenhao.tdd.bank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.wenhao.tdd.bank.exception.CustomerException;
import com.github.wenhao.tdd.bank.exception.DuplicateNicknameException;
import com.github.wenhao.tdd.bank.exception.InvalidNicknameException;
import com.github.wenhao.tdd.bank.validator.CustomerValidator;

public class AdministratorTest
{

    private Administrator administrator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp()
    {
        this.administrator = new Administrator(new CustomerValidator());
    }

    @Test
    public void should_add_customer_with_valid_customer_information() throws CustomerException
    {
        // given
        Customer customerToBeAdd = new Customer().withNickname("jack");

        // when
        Customer customer = this.administrator.create(customerToBeAdd);

        // then
        assertThat(customer.getNickname()).isEqualTo("jack");
    }

    @Test
    public void should_raise_error_if_nickname_has_uppercase_letter() throws CustomerException
    {
        thrown.expect(InvalidNicknameException.class);

        // given
        Customer customerToBeAdd = new Customer().withNickname("UPPER_jack");

        // when
        this.administrator.create(customerToBeAdd);
    }

    @Test
    public void should_raise_error_if_nickname_has_special_character() throws CustomerException
    {
        thrown.expect(InvalidNicknameException.class);

        // given
        Customer customerToBeAdd = new Customer().withNickname("@#$123");

        // when
        this.administrator.create(customerToBeAdd);
    }

    @Test
    public void should_raise_error_if_nickname_already_existed() throws CustomerException
    {
        thrown.expect(DuplicateNicknameException.class);

        // given
        Customer existedCustomer = new Customer().withNickname("existed2nickname");

        // when
        this.administrator.create(existedCustomer);
    }
}
