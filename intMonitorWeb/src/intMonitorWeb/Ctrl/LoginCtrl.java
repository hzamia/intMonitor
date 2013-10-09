package intMonitorWeb.Ctrl;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.intt.intMonitor.buisnessobject.AuthentificationServiceRemote;
import tn.intt.intMonitor.entities.Users;
import tn.intt.intMonitor.exception.NotAutorizedException;

@SessionScoped
@ManagedBean
public class LoginCtrl {

	public Users users  = new Users();
	@EJB
	AuthentificationServiceRemote authentificationLocal;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	public String doLogin(){
		try {
			String role = authentificationLocal.authenficate(users);
			if (role.equals("admin")) {
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.jsf");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (role.equals("user")) {
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("user.jsf");
					return "user";
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} catch (NotAutorizedException e) {
	        FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Authenfication Erreur", "Login/password Inccorect"));  
			return "error";
		}
		return "admin";
	}

		public void doLogout()
		{
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
		}
	}


