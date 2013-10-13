package tn.intt.intMonitor.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.intt.intMonitor.dao.inter.LoggingDaoRemote;
import tn.intt.intMonitor.entities.Logging;

/**
 * Session Bean implementation class LoggingDao
 */
@Stateless
@LocalBean
public class LoggingDao implements LoggingDaoRemote {

	@PersistenceContext(unitName="intMonitorEJB")
	EntityManager entityManager;	
	
    /**
     * Default constructor. 
     */
    public LoggingDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Logging findLogs(int seq) {
		return entityManager.find(Logging.class, seq);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Logging> getAllLogs() {
		return entityManager.createQuery("from Logging").getResultList();
	}

	@Override
	public List<Logging> getHostLog() {
		String jpql="SELECT l FROM Logging l where l.host='root.intt.tn'";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public Long getPriorityCount(String priority) {
			
		Query query = entityManager.createQuery("SELECT COUNT(l) FROM Logging l where l.priority= :priority");
		query.setParameter("priority", priority);
		return (Long)query.getSingleResult();

	}

	@Override
	public Long getLogsCountByHost(String host) {
		Query query = entityManager.createQuery("SELECT COUNT(l) FROM Logging l where l.host= :host");
		query.setParameter("host", host);
		return (Long)query.getSingleResult();
	}

}
