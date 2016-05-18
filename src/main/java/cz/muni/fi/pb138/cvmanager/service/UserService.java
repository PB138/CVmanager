package cz.muni.fi.pb138.cvmanager.service;

import cz.muni.fi.pb138.cvmanager.dao.UserDao;
import cz.muni.fi.pb138.cvmanager.entity.User;
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
    private UserDao userDao;

//    public User loadUserByUsername(String username) {
//
//        return userDao.getUser(username);
//    }


    public void login(String username){
//        User user = userDao.findOne(username);
//        if (user != null) {
////            userDao.save(user);

//        }
}
    public User findOne(String username){
        return userDao.getUser(username);
    }

    public void register(User user) {
        userDao.register(user);
    }
}
