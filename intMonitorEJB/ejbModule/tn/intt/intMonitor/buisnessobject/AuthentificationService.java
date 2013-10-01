package tn.intt.intMonitor.buisnessobject;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.intt.intMonitor.dao.inter.UsersDaoRemote;
import tn.intt.intMonitor.entities.Users;
import tn.intt.intMonitor.exception.NotAutorizedException;

/**
 * Session Bean implementation class AuthentificationService
 */
@Stateless
public class AuthentificationService implements AuthentificationServiceRemote {

    /**
     * Default constructor. 
     */
    public AuthentificationService() {
        // TODO Auto-generated constructor stub
    }

    @EJB
	UsersDaoRemote usersDao ;
	
 

	@Override
	public String authenficate(Users users) throws NotAutorizedException {
        Users usersToFind =usersDao.findUser(users.getLogin());
        if (usersToFind== null) throw new NotAutorizedException();
		if (!(usersToFind.getPassword().equals(users.getPassword()))) throw new NotAutorizedException() ;
	    return usersToFind.getRole();      		
	}

}
