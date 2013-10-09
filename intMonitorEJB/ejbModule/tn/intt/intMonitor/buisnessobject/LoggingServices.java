package tn.intt.intMonitor.buisnessobject;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.intt.intMonitor.entities.Logging;

/**
 * Session Bean implementation class LoggingServices
 */
@Stateless
@LocalBean
public class LoggingServices implements LoggingServicesRemote {

	
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public LoggingServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Logging findLogs(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Logging> getAllLogs() {
		String jpql="SELECT l FROM logs l"; 
		return entityManager.createQuery(jpql).getResultList();
	}

}
