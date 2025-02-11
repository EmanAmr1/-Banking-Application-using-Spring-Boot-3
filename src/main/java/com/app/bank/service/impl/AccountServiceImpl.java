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

    @Override
    public AccountDto getAccount(Long id) {
        Account account= accountRepo.findById(id).orElseThrow(()-> new RuntimeException("ACC not found"));
        return AccountMapper.mapTpAccountDto(account);
    }

    @Override
    public AccountDto deposit(Double amount, Long id) {

        Account account= accountRepo.findById(id).orElseThrow(()-> new RuntimeException("ACC not found"));
        Double total= account.getBalance() + amount;
        account.setBalance(total);
        Account savedAcc= accountRepo.save(account);
        return AccountMapper.mapTpAccountDto(savedAcc);

    }
}
