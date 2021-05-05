package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.model.AccountModel;
import com.example.demo.repo.AccountRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AccountServiceImpl<accountDto> implements AccountService{

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        super();
        this.accountRepository=accountRepository;
    }

    @Override
    public List<AccountModel> getAllAccountDetails() {

       return accountRepository.findAll();

    }

    @Override
    public AccountDto createAccount(AccountDto accountDto){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model=modelMapper.map(accountDto,AccountModel.class);
        accountRepository.save(model);
        AccountDto dto=modelMapper.map(model, AccountDto.class);

        return accountDto;
    }

    @Override
    public AccountDto findByAccountId(String accountId) {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model=accountRepository.findByAccountId(accountId);
        if(model==null)
        {            throw new AccountNotFoundException("no employee found with the given id: "+accountId);

        }
        AccountDto dto=modelMapper.map(model, AccountDto.class);
        return dto;
    }

    @Override
    public AccountDto findByEmail(String email) {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model=accountRepository.findByEmail(email);
        System.out.println(model);

        return (mapper.map(model,AccountDto.class));

    }

    @Override
    public List<AccountModel> findByFirstName(String FirstName) {
        List<AccountModel> accountModels=accountRepository.findByFirstName(FirstName);
        return  accountModels;

    }

    @Override
    @Transactional
    public Integer deleteByAccountId(String accountId) {

        return accountRepository.deleteByAccountId(accountId);
    }

    @Override
    public Integer deleteByFirstName(String FirstName) {
        return null;
    }

    @Override
    @Transactional
    public AccountDto updateAccount(String accountId, AccountDto accountDto) {
        AccountModel accountModel=accountRepository.findByAccountId(accountId);
        if(accountModel==null)
        {
            throw new AccountNotFoundException("no such account found");
        }
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountModel model=mapper.map(accountDto, AccountModel.class);
        accountModel.setFirstName(model.getFirstName());
        accountModel.setLastName(model.getLastName());
        accountModel.setEmail(model.getEmail());
        accountRepository.save(accountModel);
        AccountDto accDto=mapper.map(accountModel, AccountDto.class);
        return accDto;
    }

    @Override
    public List<AccountModel> findByFirstNameOrLastName(String FirstName, String Lastname) {
        List<AccountModel> accountModels=accountRepository.findByFirstNameOrLastName(FirstName,Lastname);
        return  accountModels;
    }


}
