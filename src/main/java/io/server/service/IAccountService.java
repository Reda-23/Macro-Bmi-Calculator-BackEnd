package io.server.service;

import io.server.entity.Account;
import io.server.exception.AccountIsMissingException;


import java.util.Collection;

public interface IAccountService {





    Account addAccount(Account account);
    Account getAccount(Long id) throws AccountIsMissingException;
    Account updateAccount(Long id, Account account) throws AccountIsMissingException;
    Collection<Account> accounts();
    Boolean deleteAccount(Long id) throws AccountIsMissingException;
    void setRoleToAccount(String rolename , String email);
}
