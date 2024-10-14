package com.banking.app.Services;

import com.banking.app.Entity.Account;
import com.banking.app.Entity.User;
import com.banking.app.Repository.AccountRepository;
import com.banking.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accRepo;
    private final UserRepository userRepo ;
    @Autowired
    public AccountService(AccountRepository accRepo, UserRepository userRepo) {
        this.accRepo = accRepo;
        this.userRepo = userRepo;
    }

    public Account createAccount(String username, String accountNumber, BigDecimal initialBalance){
        User user = userRepo.findByUsername(username)
                .orElseThrow(()->new RuntimeException("User not found"));

        Account account = Account.builder()
                .accountNumber(accountNumber)
                .balance(initialBalance)
                .user(user)
                .build();
        return accRepo.save(account);
    }
}
