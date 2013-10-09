package tn.intt.intMonitor.buisnessobject;

import java.util.List;

import javax.ejb.Remote;

import tn.intt.intMonitor.entities.Logs;

@Remote
public interface LogsServicesRemote {

	public Logs findLogs(int seq);
	public List<Logs> getAllLogs();
}
