package tn.intt.intMonitor.buisnessobject;

import java.util.List;

import javax.ejb.Remote;

import tn.intt.intMonitor.entities.Logging;

@Remote
public interface LoggingServicesRemote {

	public Logging findLogs(int seq);
	public List<Logging> getAllLogs();
	
}
