package ch.koalix.restfulApplicationTemplate.repository;

import ch.koalix.restfulApplicationTemplate.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Account repository interface.
 *
 * Created by Hacont on 04.10.2016.
 */
@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select a from Account a")
    ArrayList<Account> getAllAccounts();
}
