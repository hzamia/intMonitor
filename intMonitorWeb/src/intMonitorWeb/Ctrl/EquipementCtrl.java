package intMonitorWeb.Ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import tn.intt.intMonitor.dao.inter.EquipmentDaoRemote;
import tn.intt.intMonitor.entities.Equipement;


@SessionScoped
@ManagedBean
public class EquipementCtrl {
	
	@EJB
	private EquipmentDaoRemote equipmentDaoRemote;
	
	
	//Models
	private Equipement equipement=new Equipement();
	private DataModel<Equipement> modelEquipement= new ListDataModel<Equipement>();
	private List<Equipement> listEquipements= new ArrayList<Equipement>();
	
	
	
	
	//Methode
	
	public EquipementCtrl() {
		// TODO Auto-generated constructor stub
	}

	public EquipmentDaoRemote getEquipmentDaoRemote() {
		return equipmentDaoRemote;
	}
	public void setEquipmentDaoRemote(EquipmentDaoRemote equipmentDaoRemote) {
		this.equipmentDaoRemote = equipmentDaoRemote;
	}
	public Equipement getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	public DataModel<Equipement> getModelEquipement() {
		modelEquipement.setWrappedData(equipmentDaoRemote.getAllEquipement());
		return modelEquipement;
	}
	public void setModelEquipement(DataModel<Equipement> modelEquipement) {
		this.modelEquipement = modelEquipement;
	}
	
	public List<Equipement> getListEquipements() {
		listEquipements =equipmentDaoRemote.getAllEquipement();
		return listEquipements;
	}
	public void setListEquipements(List<Equipement> listEquipements) {
		this.listEquipements = listEquipements;
	}
	
	
	public String doAddEquipement()
	{
		
		Equipement equipements=new Equipement();
		equipements.setIp(equipement.getIp());
		equipements.setName(equipement.getName());
		equipements.setType(equipement.getType());
		equipmentDaoRemote.addEquipent(equipements);
		return "";
		
	}
	
	
	
	public String doDeleteUser()
	{
		Equipement equipementtmp= modelEquipement.getRowData();
		equipmentDaoRemote.delEquipement(equipementtmp.getId());
		return "";
	}
	
	
	
	
}
