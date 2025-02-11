package com.app.bank.controller;

import com.app.bank.dto.AccountDto;
import com.app.bank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/createAccount")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAccount/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccount(id));
    }


    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto> deposit(@RequestBody Map<String,Double> request , @PathVariable Long id){
       Double amount = request.get("amount");
        return ResponseEntity.ok(accountService.deposit(amount,id));
    }

}
