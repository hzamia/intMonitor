package tn.intt.intMonitor.dao.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.intt.intMonitor.entities.Equipement;
import tn.intt.intMonitor.entities.Users;

@Remote
public interface EquipmentDaoRemote {
	
	public void addEquipent(Equipement equipement);
	public void delEquipement (int id);
	public Equipement findEquipement(int ip);
	public List<Equipement> getAllEquipement();

}
