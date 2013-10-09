package tn.intt.intMonitor.buisnessobject;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.intt.intMonitor.entities.Logs;

/**
 * Session Bean implementation class LogsServices
 */
@Stateless
@LocalBean
public class LogsServices implements LogsServicesRemote {

	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public LogsServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Logs findLogs(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Logs> getAllLogs() {
		String jpql="SELECT l FROM logs l"; 
		return entityManager.createQuery(jpql).getResultList();
	}

}
