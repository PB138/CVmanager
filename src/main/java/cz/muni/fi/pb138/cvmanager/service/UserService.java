package cz.muni.fi.pb138.cvmanager.service;

import cz.muni.fi.pb138.cvmanager.dao.AccountDao;
import cz.muni.fi.pb138.cvmanager.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * Created by zeman on 18-May-16.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private AccountDao accountDao;

//    public Account loadUserByUsername(String username) {
//
//        return userDao.getUser(username);
//    }


    public void login(String username){
//        Account account = userDao.findOne(username);
//        if (account != null) {
////            userDao.save(account);

//        }
}
    public Account findOne(String username){
        return accountDao.findOne(username);
    }

    public void register(Account account) {
        accountDao.save(account);
    }
}
