package com.github.wenhao.tdd.bank.validator;

import com.github.wenhao.tdd.bank.Customer;
import com.github.wenhao.tdd.bank.exception.DuplicateNicknameException;
import com.github.wenhao.tdd.bank.repository.Persistence;

public class DuplicateValidator extends Validator
{
    private Persistence persistence;

    public DuplicateValidator(Persistence persistence)
    {
        this.persistence = persistence;
    }

    public void validate(Customer customer) throws DuplicateNicknameException
    {
        if (persistence.isExist(customer.getNickname())) {
            throw new DuplicateNicknameException();
        }
    }
}
