package tn.intt.intMonitor.buisnessobject;

import java.util.List;

import javax.ejb.Remote;

import tn.intt.intMonitor.entities.Users;

@Remote
public interface UsersServicesRemote {
	void addUser(Users users);
	List<Users> listAllUsers();
	void deleteUserById(String login);
	void updateUser(Users users);

}
