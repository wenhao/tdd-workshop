package com.github.wenhao.tdd.bank.validator;

import com.github.wenhao.tdd.bank.exception.DuplicateNicknameException;
import com.github.wenhao.tdd.bank.repository.Persistence;

public class DuplicateValidator implements Validator
{
    private Persistence persistence;

    public DuplicateValidator(Persistence persistence)
    {
        this.persistence = persistence;
    }

    public void validate(String nickname) throws DuplicateNicknameException
    {
        if (persistence.isExist(nickname)) {
            throw new DuplicateNicknameException();
        }
    }
}
