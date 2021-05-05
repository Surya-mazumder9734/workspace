package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.AccountModel;

import java.util.List;

public interface AccountService {
    public List<AccountModel> getAllAccountDetails();

    public AccountDto createAccount(AccountDto accountDto);
    public AccountDto findByAccountId(String accountId);
    public AccountDto findByEmail(String email);
    public List<AccountModel> findByFirstName(String FirstName);

   public Integer deleteByAccountId(String accountId);
   public Integer deleteByFirstName(String FirstName);
    public AccountDto updateAccount(String accountId,AccountDto accountDto);
    public List<AccountModel>findByFirstNameOrLastName(String FirstName,String Lastname);


}
