package tn.intt.intMonitor.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.intt.intMonitor.dao.inter.LogsDaoRemote;
import tn.intt.intMonitor.entities.Logs;

/**
 * Session Bean implementation class LogsDao
 */
@Stateless
@LocalBean
public class LogsDao implements LogsDaoRemote {

	@PersistenceContext(unitName="intMonitorEJB")
	EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public LogsDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Logs findLogs(int seq) {
		return entityManager.find(Logs.class, seq) ;
	}

	

	@Override
	public List<Logs> getAllLogs() {
		return entityManager.createQuery("from logs").getResultList();
	}

}
