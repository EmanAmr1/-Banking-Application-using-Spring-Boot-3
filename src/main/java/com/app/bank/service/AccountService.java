package com.app.bank.service;


import com.app.bank.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount (AccountDto accountDto);

    AccountDto getAccount(Long id);

    AccountDto deposit(Double amount, Long id);

}
