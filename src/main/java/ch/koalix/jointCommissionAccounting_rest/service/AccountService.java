package ch.koalix.jointCommissionAccounting_rest.service;

import ch.koalix.jointCommissionAccounting_rest.model.Account;

import java.util.ArrayList;

/**
 * Created by Hacont on 04.10.2016.
 */
public interface AccountService {
    ArrayList<Account> getAllAccounts();
}
