package com.poly.lab8.repository;

import com.poly.lab8.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, String> {
}
