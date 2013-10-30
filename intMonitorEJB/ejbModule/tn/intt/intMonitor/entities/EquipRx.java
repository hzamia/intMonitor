package tn.intt.intMonitor.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EquipRx
 *
 */
@Entity

public class EquipRx implements Serializable {

	
	private String ip;
	private String hostName;
	//private List<Logging> loggings;
	private static final long serialVersionUID = 1L;

	public EquipRx() {
		super();
	}   
	@Id    
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}   
	public String getHostName() {
		return this.hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
	/*@OneToMany(mappedBy="equipRx",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public List<Logging> getLoggings() {
		return loggings;
	}
	public void setLoggings(List<Logging> loggings) {
		this.loggings = loggings;
	}*/
   
}
