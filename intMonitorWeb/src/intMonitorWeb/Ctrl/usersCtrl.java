package intMonitorWeb.Ctrl;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import tn.intt.intMonitor.dao.inter.UsersDaoRemote;
import tn.intt.intMonitor.entities.Users;


@SessionScoped
@ManagedBean
public class usersCtrl {
	
	// Models
	private Users user = new Users();
	private List<Users> listuser=new ArrayList<Users>();
	private DataModel<Users> modelUsers = new ListDataModel<Users>();
	private Users selectUsers= new Users();
			
			@EJB
			private UsersDaoRemote usersDaoRemote;
			
			
			//methode
			public String doAddUser()
			{
				
				Users users=new Users();
				users.setLogin(user.getLogin());
				users.setEmail(user.getEmail());
				users.setPassword(user.getPassword());
				users.setRole(user.getRole());
				usersDaoRemote.addUsers(users);
				return "";
				
			}
			
			public String selectUser(){
				selectUsers =modelUsers.getRowData();
				return "updateUser";
			}
			
			public String doDeleteUser()
			{
				Users userTmp= modelUsers.getRowData();
				usersDaoRemote.delUsers(userTmp.getLogin());
				return "";
			}
			
			
			public Users getUser() {
				return user;
			}
			
			public void setUser(Users user) {
				this.user = user;
			}


			public List<Users> getListuser() {
				listuser = usersDaoRemote.getAllUser();
				return listuser;
			}

			
			public void setListuser(List<Users> listuser) {
				this.listuser = listuser;
			}


			public DataModel<Users> getModelUsers() {
					modelUsers.setWrappedData(usersDaoRemote.getAllUser());
					return modelUsers;
			}


			public void setModelUsers(DataModel<Users> modelUsers) {
				this.modelUsers = modelUsers;
			}
						
			
			public Users getSelectUsers() {
				return selectUsers;
			}


			public void setSelectUsers(Users selectUsers) {
				this.selectUsers = selectUsers;
			}


		

}
