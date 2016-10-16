package ch.koalix.jointCommissionAccounting_rest.service;

import ch.koalix.jointCommissionAccounting_rest.model.Account;

import java.util.List;

/**
 * Created by Hacont on 04.10.2016.
 */
public interface AccountService {
    List<Account> getAllAccounts();

    void saveAccount(Account account);

    Account updateAccount(Account account, Integer accountId);

    boolean deleteAccount(Integer accountId);
}
