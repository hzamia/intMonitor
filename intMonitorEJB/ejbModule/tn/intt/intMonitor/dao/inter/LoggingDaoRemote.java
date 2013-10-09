package tn.intt.intMonitor.dao.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.intt.intMonitor.entities.Logging;

@Remote
public interface LoggingDaoRemote {

	public Logging findLogs(int seq);
	public List<Logging> getAllLogs();	
}
