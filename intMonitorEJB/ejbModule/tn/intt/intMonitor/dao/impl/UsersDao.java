package tn.intt.intMonitor.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.intt.intMonitor.dao.inter.UsersDaoRemote;
import tn.intt.intMonitor.entities.Users;

/**
 * Session Bean implementation class UsersDao
 */
@Stateless
@LocalBean
public class UsersDao implements UsersDaoRemote {

	
	@PersistenceContext(unitName="intMonitorEJB")
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public UsersDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addUsers(Users user) {
		entityManager.persist(user);
		
	}

	@Override
	public void delUsers(String login) {
		entityManager.remove(findUser(login));
		
	}

	@Override
	public Users findUser(String login) {
		return entityManager.find(Users.class, login);
	}

	@Override
	public void updUsers(Users user) {
          entityManager.merge(user);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAllUser() {
		return entityManager.createQuery("from Users").getResultList();
	}

}
