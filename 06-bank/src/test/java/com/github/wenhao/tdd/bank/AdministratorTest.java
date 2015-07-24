package com.github.wenhao.tdd.bank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.wenhao.tdd.bank.builder.CustomerBuilder;
import com.github.wenhao.tdd.bank.builder.CustomerValidatorBuilder;
import com.github.wenhao.tdd.bank.exception.CustomerException;
import com.github.wenhao.tdd.bank.exception.DuplicateNicknameException;
import com.github.wenhao.tdd.bank.exception.InvalidNicknameException;
import com.github.wenhao.tdd.bank.repository.Persistence;
import com.github.wenhao.tdd.bank.validator.CustomerValidator;
import com.github.wenhao.tdd.bank.validator.DuplicateValidator;
import com.github.wenhao.tdd.bank.validator.SpecialCharacterValidator;

public class AdministratorTest
{

    private Administrator administrator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp()
    {
        Persistence persistence = new Persistence();
        CustomerValidator customerValidator = new CustomerValidatorBuilder()
                .addValidator(new DuplicateValidator(persistence))
                .addValidator(new SpecialCharacterValidator())
                .createCustomerValidator();
        this.administrator = new Administrator(customerValidator, persistence);
    }

    @Test
    public void should_add_customer_with_valid_customer_information() throws CustomerException
    {
        // given
        Customer customerToBeAdd = new CustomerBuilder().withNickname("jack").createCustomer();

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
        Customer customerToBeAdd = new CustomerBuilder().withNickname("UPPER_jack").createCustomer();

        // when
        this.administrator.create(customerToBeAdd);
    }

    @Test
    public void should_raise_error_if_nickname_has_special_character() throws CustomerException
    {
        thrown.expect(InvalidNicknameException.class);

        // given
        Customer customerToBeAdd = new CustomerBuilder().withNickname("@#$123").createCustomer();

        // when
        this.administrator.create(customerToBeAdd);
    }

    @Test
    public void should_raise_error_if_nickname_already_existed() throws CustomerException
    {
        thrown.expect(DuplicateNicknameException.class);

        // given
        Customer customer = new CustomerBuilder().withNickname("jack").createCustomer();
        this.administrator.create(customer);

        // when
        this.administrator.create(customer);
    }
}
