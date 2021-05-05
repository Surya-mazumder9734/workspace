package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import  com.example.demo.model.AccountModel;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel,Integer> {
    @Query
    AccountModel findByAccountId(String accountId);
    @Query
    AccountModel findByEmail(String email);
    @Query
    Integer deleteByAccountId(String accountId);
    @Query
    Integer deleteByFirstName(String FirstName);
    @Query
    public List<AccountModel> findByFirstName(String FirstName);

    @Query
    public List<AccountModel>findByFirstNameOrLastName(String FirstName,String Lastname);

}
