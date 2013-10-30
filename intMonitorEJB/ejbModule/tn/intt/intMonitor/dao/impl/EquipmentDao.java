package tn.intt.intMonitor.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.intt.intMonitor.dao.inter.EquipmentDaoRemote;
import tn.intt.intMonitor.entities.Equipement;
import tn.intt.intMonitor.entities.Users;

/**
 * Session Bean implementation class EquipmentDao
 */
@Stateless
@LocalBean
public class EquipmentDao implements EquipmentDaoRemote {
	
	@PersistenceContext(unitName="intMonitorEJB")
	EntityManager entityManager;	

    /**
     * Default constructor. 
     */
    public EquipmentDao() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addEquipent(Equipement equipement) {
			entityManager.persist(equipement);
	}

	@Override
	public void delEquipement(int id) {
			entityManager.remove(findEquipement(id));
	}

	@Override
	public Equipement findEquipement(int ip) {
		return entityManager.find(Equipement.class,ip);
	}

	@Override
	public List<Equipement> getAllEquipement() {
		return entityManager.createQuery("from Equipement").getResultList();
	}

}
