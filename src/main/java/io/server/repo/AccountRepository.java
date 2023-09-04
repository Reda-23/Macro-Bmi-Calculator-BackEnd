package io.server.repo;

import io.server.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findAccountByEmail(String email);
}
