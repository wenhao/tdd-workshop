package com.github.wenhao.tdd.bank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.github.wenhao.tdd.bank.exception.DuplicateNicknameException;
import com.github.wenhao.tdd.bank.exception.InvalidNicknameException;
import com.github.wenhao.tdd.bank.repository.Persistence;

public class AdministratorTest
{

    private Administrator administrator;

    @Before
    public void setUp() throws Exception
    {
        this.administrator = new Administrator(new Persistence());
    }

    @Test
    public void should_add_customer_with_valid_customer_information() throws InvalidNicknameException, DuplicateNicknameException
    {
        // given
        Customer customerToBeAdd = new Customer().withNickname("jack");

        // when
        Customer customer = this.administrator.create(customerToBeAdd);

        // then
        assertThat(customer.getNickname()).isEqualTo("jack");
    }

    @Test(expected = InvalidNicknameException.class)
    public void should_raise_error_if_nickname_has_uppercase_letter() throws InvalidNicknameException, DuplicateNicknameException
    {
        // given
        Customer customerToBeAdd = new Customer().withNickname("UPPER_jack");

        // when
        this.administrator.create(customerToBeAdd);
    }

    @Test(expected = InvalidNicknameException.class)
    public void should_raise_error_if_nickname_has_special_character() throws InvalidNicknameException, DuplicateNicknameException
    {
        // given
        Customer customerToBeAdd = new Customer().withNickname("@#$123");

        // when
        this.administrator.create(customerToBeAdd);
    }

    @Test(expected = DuplicateNicknameException.class)
    public void should_raise_error_if_nickname_already_existed() throws InvalidNicknameException, DuplicateNicknameException
    {
        // given
        Customer existedCustomer = new Customer().withNickname("existed2nickname") ;

        // when
        this.administrator.create(existedCustomer);
    }
}
