package tn.intt.intMonitor.buisnessobject;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.intt.intMonitor.entities.Users;

/**
 * Session Bean implementation class UsersServices
 */
@Stateless
@LocalBean
public class UsersServices implements UsersServicesRemote {

	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public UsersServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addUser(Users users) {
			entityManager.persist(users);		
	}

	@Override
	public List<Users> listAllUsers() {
		
		String jpql="SELECT u FROM users u"; 
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public void deleteUserById(String login) {
		entityManager.remove(entityManager.find(Users.class, login));
	}

	@Override
	public void updateUser(Users users) {
		entityManager.merge(users);
	}
	

    
}
