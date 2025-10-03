package com.poly.lab8.service;

import com.poly.lab8.model.Account;
import com.poly.lab8.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDAO dao;

    @Override
    public Account findById(String username) {
        return dao.findById(username).orElse(null);
    }
}
