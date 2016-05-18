package cz.muni.fi.pb138.cvmanager.dao;

import cz.muni.fi.pb138.cvmanager.entity.Account;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zeman on 18-May-16.
 */
@Repository
public  interface AccountDao extends CrudRepository<Account, String>{

//    @Autowired
//    private  SessionFactory sessionFactory;///= new Configuration().configure().buildSessionFactory();



//    public Account findByUsername(String username);



//    private Session openSession() {
//        return sessionFactory.getCurrentSession();
//    }

//    public Account getUser(String username) ;

//        Query query = openSession().createQuery("from USERS u where u.USERNAME = :username");
//        List<Account> userList =query.setParameter("username", username).list();
//
//        if (userList.size() > 0)
//            return userList.get(0);
//        else
//            return null;
//        return null;
//    }


//    public void register(Account account) ;

}
