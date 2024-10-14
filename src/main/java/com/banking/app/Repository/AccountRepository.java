package com.banking.app.Repository;

import com.banking.app.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    //custom query methods
    Optional<Account> findByAccountNumber(String accountNumber);

    boolean ExistsByAccountNumber(String AccountNumber);
}
