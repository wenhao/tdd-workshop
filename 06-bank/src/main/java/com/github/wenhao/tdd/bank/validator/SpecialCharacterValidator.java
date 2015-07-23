package com.github.wenhao.tdd.bank.validator;

import com.github.wenhao.tdd.bank.exception.InvalidNicknameException;

public class SpecialCharacterValidator implements Validator
{

    public void validate(String nickname) throws InvalidNicknameException
    {
        if (!nickname.matches("([a-z0-9])+")) {
            throw new InvalidNicknameException();
        }
    }
}
