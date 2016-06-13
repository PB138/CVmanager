package cz.muni.fi.pb138.cvmanager.service;

import cz.muni.fi.pb138.cvmanager.dao.AccountDao;
import cz.muni.fi.pb138.cvmanager.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * Created by zeman on 18-May-16.
 */
@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Signs in given user
     * Uses account repository to find and return given user
     *
     * @param username we are trying to sign in
     * @return if user was found then it returns it if not then null
     */
    public Account login(String username){
        return accountDao.findOne(username);
    }

    /**
     * Creates new user account with information from
     * @param account given account with user information
     */
    public void register(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole("ROLE_USER");
        account.setEnabled(true);
        accountDao.save(account);
    }

    /**
     * Finds all users in database
     * @return all users in database
     */
    public Iterable<Account> findAll() {
        return accountDao.findAll();
    }

    /**
     * Removes user from database
     * @param username username to remove
     */
    public void removeUser(String username) {
        accountDao.delete(username);
    }
}
