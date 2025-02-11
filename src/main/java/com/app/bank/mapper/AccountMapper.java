package com.app.bank.mapper;

import com.app.bank.dto.AccountDto;
import com.app.bank.entity.Account;

public class AccountMapper {

    public static Account MapTpAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );

        return account;
    }

    public static AccountDto MapTpAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
