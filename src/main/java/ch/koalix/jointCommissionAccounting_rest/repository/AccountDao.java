package ch.koalix.jointCommissionAccounting_rest.repository;

import ch.koalix.jointCommissionAccounting_rest.model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Account repository interface.
 *
 * Created by Hacont on 04.10.2016.
 */
@Repository("accountDao")
@Transactional(propagation = Propagation.REQUIRED)
public class AccountDao {

    private static final String SELECT_ALL = "select a from Account a";

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Gets all accounts.
     * @return list of all stored accounts
     */
    public List<Account> selectAll() {
        Query query = entityManager.createQuery(SELECT_ALL);
        List<Account> accounts = query.getResultList();

        return accounts;
    }

    /**
     * Stores a new account to database.
     * @param account the account to persist
     */
    public Account saveAccount(Account account) {
        entityManager.persist(account);
        return account;
    }

    /**
     * Updates the account with technical id accountId.
     * @param account the new data to update the account
     * @param accountId the technical id of the account record
     *
     * @return the updated account entity
     */
    public Account updateAccount(Account account, Integer accountId) {
        Account acc = entityManager.find(Account.class, accountId);
        acc.setAccountNumber(account.getAccountNumber());
        acc.setAccountName(account.getAccountName());

        return acc;
    }

    /**
     * Deletes the account with technical id accountId.
     * @param accountId the technical id of the account
     * @return true if account was deleted, false if not
     */
    public boolean deleteAccount(Integer accountId) {
        Account acc = entityManager.find(Account.class, accountId);
        entityManager.remove(acc);

        return !entityManager.contains(acc);
    }
}
