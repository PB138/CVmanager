package cz.muni.fi.pb138.cvmanager.dao;

import cz.muni.fi.pb138.cvmanager.entity.Account;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zeman on 18-May-16.
 */

/**
 * Repository for Crud operations with Account database
 */
@Repository
public  interface AccountDao extends CrudRepository<Account, String>{
}
