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


    public Account login(String username){
        return accountDao.findOne(username);
    }

    public void register(Account account) {


        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole("ROLE_USER");
        account.setEnabled(true);
        accountDao.save(account);
    }

    public Iterable<Account> findAll() {
        return accountDao.findAll();
    }


    public void removeUser(String username) {
        accountDao.delete(username);
    }
}
