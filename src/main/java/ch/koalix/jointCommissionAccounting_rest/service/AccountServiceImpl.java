package ch.koalix.jointCommissionAccounting_rest.service;

import ch.koalix.jointCommissionAccounting_rest.model.Account;
import ch.koalix.jointCommissionAccounting_rest.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Hacont on 04.10.2016.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> getAllAccounts() {
        return accountDao.selectAll();
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public Account updateAccount(Account account, Integer accountId) {
        return accountDao.updateAccount(account, accountId);
    }

    public boolean deleteAccount(Integer accountId) {
        return accountDao.deleteAccount(accountId);
    }
}
