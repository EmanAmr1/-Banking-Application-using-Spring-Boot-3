package com.app.bank.service.impl;

import com.app.bank.dto.AccountDto;
import com.app.bank.entity.Account;
import com.app.bank.mapper.AccountMapper;
import com.app.bank.repository.AccountRepo;
import com.app.bank.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= accountRepo.save(AccountMapper.mapTpAccount(accountDto));
        AccountDto accountdto = AccountMapper.mapTpAccountDto(account);
        return accountdto;
    }
}
