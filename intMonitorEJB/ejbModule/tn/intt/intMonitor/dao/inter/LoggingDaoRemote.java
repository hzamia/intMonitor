package tn.intt.intMonitor.dao.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.intt.intMonitor.entities.Logging;

@Remote
public interface LoggingDaoRemote {

	public Logging findLogs(int seq);
	public List<Logging> getAllLogs();
	public List<Logging> getHostLog();
	public Long getPriorityCount(String facility);
	public List<Logging> getLogsByHost(String host);
	public List<Logging> getlistHosts();
	public List<Logging> getLogsSuccessLoginAd();
	public List<Logging> getLogsLogOffAd();
	public List<Logging> getlogsOthersAd();
	public List<Logging> getPriorityByHost(String priority,String host);
	
}
