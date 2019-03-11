package com.github.wenhao.tdd.bank;

import com.github.wenhao.tdd.bank.exception.DuplicateNicknameException;
import com.github.wenhao.tdd.bank.stub.MessageGatewayStub;
import static org.assertj.core.api.Assertions.assertThat;
import static org.joda.time.DateTime.now;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {

    private Bank bank;
    private MessageGatewayStub messageGatewayStub;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        messageGatewayStub = new MessageGatewayStub();
        customer = new Customer("jack", now(), messageGatewayStub);
        this.bank = new Bank(messageGatewayStub);
    }

    @Test
    public void should_add_customer_with_valid_customer_information() throws DuplicateNicknameException {
        // given

        // when
        Customer customer = this.bank.create(this.customer);

        // then
        assertThat(customer.getNickname()).isEqualTo("jack");
        assertThat(messageGatewayStub.getRecipient()).isEqualTo("jack@thebank.com");
        assertThat(messageGatewayStub.getContent()).isEqualTo("Dear jack, Welcome to the Bank");
    }

    @Test
    public void should_raise_error_if_nickname_already_existed() throws DuplicateNicknameException {
        // given
        this.bank.create(customer);

        // when
        assertThrows(DuplicateNicknameException.class, () -> this.bank.create(customer));
    }

    @Test
    public void should_set_join_date_as_today_when_add_customer() throws DuplicateNicknameException {
        // when
        Customer customer = this.bank.create(this.customer);

        // then
        assertThat(customer.getJoinDate().dayOfYear()).isEqualTo(now().dayOfYear());
    }
}
