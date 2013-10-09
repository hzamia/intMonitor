package tn.intt.intMonitor.dao.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.intt.intMonitor.entities.Logs;

@Remote
public interface LogsDaoRemote {
	
	public Logs findLogs(int seq);
	public List<Logs> getAllLogs();
	
}
