package com.example.demo.controller;
import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

import com.example.demo.dto.AccountDto;
import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.exception.EmailNotFoundException;
import com.example.demo.model.AccountModel;
import com.example.demo.service.AccountService;
import com.example.demo.shared.AccountRequestModel;
import com.example.demo.shared.AccountResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api")
@Validated

public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        super();
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<AccountResponseModel> createAccount(@Valid @RequestBody AccountRequestModel accRequestModel) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto accountDto = mapper.map(accRequestModel, AccountDto.class);
        accountDto.setAccountId(UUID.randomUUID().toString());
        AccountDto response = accountService.createAccount(accountDto);
        AccountResponseModel model = mapper.map(response, AccountResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(model);

    }
    @GetMapping(path = "/accounts/{accountId}")
    public ResponseEntity<AccountResponseModel> findByAccountId(@PathVariable("accountId") String accountId){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto response=accountService.findByAccountId(accountId);
        AccountResponseModel model=mapper.map(response,AccountResponseModel.class);
        return ResponseEntity.ok(model);
    }
    @GetMapping(path = "/accounts/details")
    public  List<AccountDto> getAllAccountDetails(){
        ModelMapper modelMapper = new ModelMapper();
       return accountService.getAllAccountDetails().stream().map(post->modelMapper.map(post,AccountDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/accounts/email/{email}")
    public ResponseEntity<AccountDto> findAccountByEmail(@PathVariable("email") String email){
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto dto=accountService.findByEmail(email);
        if (dto==null){
            throw new EmailNotFoundException("email not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @GetMapping("/accounts/name/{FirstName}")
    public ResponseEntity<List<AccountResponseModel>> findAccountByFirstName(@PathVariable("FirstName") String FirstName){
        List<AccountModel> list=accountService.findByFirstName(FirstName);
        List<AccountResponseModel> responseModels=new ArrayList<AccountResponseModel>();
        Iterator<AccountModel> i=list.iterator();
        while (i.hasNext()){
            AccountModel m= i.next();
            AccountResponseModel model=new AccountResponseModel();
            if (list.isEmpty()){
                throw new AccountNotFoundException("account not found");

            }else{
                model.setAccountId(m.getAccountId());
                model.setFirstName(m.getFirstName());
                model.setLastName(m.getLastName());
                model.setEmail(m.getEmail());
            }
        }
        return ResponseEntity.ok(responseModels);
    }
    @DeleteMapping("/accounts/{accountId}")
    public ResponseEntity<Integer> deleteAccount(@PathVariable("accountId") String accountId) {

        Integer result=accountService.deleteByAccountId(accountId);
        if(result<1)
        {
            throw new AccountNotFoundException("no account found.");
        }
        return ResponseEntity.ok(result);

    }
    @PutMapping("/accounts/{accountid}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable("accountid")@Min(1) String accountId,
                                                    @RequestBody AccountRequestModel requestModel)
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        AccountDto dto= mapper.map(requestModel, AccountDto.class);
        AccountDto d= accountService.updateAccount(accountId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }
    @GetMapping("/accounts/name/find/{FirstName}/{LastName}")
    public ResponseEntity<List<AccountResponseModel>> findByFirstNameOrLastName(@PathVariable("FirstName") String FirstName,@PathVariable("LastName") String LastName) {
        List<AccountModel> list = accountService.findByFirstNameOrLastName(FirstName, LastName);
        List<AccountResponseModel> responseModels = new ArrayList<AccountResponseModel>();
        Iterator<AccountModel> i = list.iterator();
        while (i.hasNext()) {
            AccountModel m = i.next();
            AccountResponseModel model = new AccountResponseModel();
            if (list.isEmpty()) {
                throw new AccountNotFoundException("account not found");

            } else {
                model.setAccountId(m.getAccountId());
                model.setFirstName(m.getFirstName());
                model.setLastName(m.getLastName());
                model.setEmail(m.getEmail());
            }
        }
return ResponseEntity.ok(responseModels);
    }
}
