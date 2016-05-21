package cz.muni.fi.pb138.cvmanager.service;

import cz.muni.fi.pb138.cvmanager.dao.AccountDao;
import cz.muni.fi.pb138.cvmanager.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;


    public void login(String username){
        accountDao.findOne(username);
       }

    public Account findOne(String username){
        return accountDao.findOne(username);
    }

    public void register(Account account) {

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        if(!account.getPassword().equals(account))
        account.setRole("ROLE_ADMIN");
        account.setEnabled(true);
        account.setSalt("Keepo");
        accountDao.save(account);
    }

    public Iterable<Account> findAll() {
        return accountDao.findAll();
    }
}
