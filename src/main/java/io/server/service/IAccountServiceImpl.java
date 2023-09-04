package io.server.service;

import io.server.entity.Account;
import io.server.entity.Role;
import io.server.exception.AccountIsMissingException;
import io.server.repo.AccountRepository;
import io.server.repo.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class IAccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;



    @Override
    public Account addAccount(Account account) {
        log.info("adding new account : {} " , account.getName());
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(Long id) throws AccountIsMissingException {
        log.info("fetching account by id {}: ",id);
        Account account = accountRepository.getReferenceById(id);
        if (account.getName().isEmpty()){
            throw new AccountIsMissingException("Account Is Missing");
        }
        return account;
    }

    @Override
    public Account updateAccount(Long id, Account account) throws AccountIsMissingException {
        log.info("updating account {}: ",account);
        Account updateAcc = accountRepository.getReferenceById(id);
        if (updateAcc.getName().isEmpty()){
            throw new AccountIsMissingException("Account Is Missing");
        }
        updateAcc.setName(account.getName());
        updateAcc.setEmail(account.getEmail());
        updateAcc.setPassword(account.getPassword());
        updateAcc.setRoles(account.getRoles());
        return accountRepository.save(updateAcc);
    }

    @Override
    public List<Account> accounts() {
        log.info("fetching all accounts  ");
        return accountRepository.findAll();
    }

    @Override
    public Boolean deleteAccount(Long id) throws AccountIsMissingException {
        log.info("updating account by id {}: ",id);
        Account account = accountRepository.getReferenceById(id);
        if (account.getName().isEmpty()){
            throw new AccountIsMissingException("Account Is Missing");
        }
        accountRepository.delete(account);
        return true;
    }

    @Override
    public void setRoleToAccount(String rolename, String email) {
        Role role = roleRepository.findRoleByRoleName(rolename);
        Account account = accountRepository.findAccountByEmail(email);
        account.setRoles(role);
    }
}
