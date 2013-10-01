package tn.intt.intMonitor.buisnessobject;

import javax.ejb.Remote;

import tn.intt.intMonitor.entities.Users;
import tn.intt.intMonitor.exception.NotAutorizedException;

@Remote
public interface AuthentificationServiceRemote {
	public String authenficate(Users users) throws NotAutorizedException ;
}
