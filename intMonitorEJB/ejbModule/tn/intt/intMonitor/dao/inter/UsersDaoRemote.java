package tn.intt.intMonitor.dao.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.intt.intMonitor.entities.Users;


@Remote
public interface UsersDaoRemote {

	public void addUsers(Users user);
	public void delUsers (String login);
	public Users findUser(String login);
	public void updUsers(Users user);
	public List<Users> getAllUser();
	
}
