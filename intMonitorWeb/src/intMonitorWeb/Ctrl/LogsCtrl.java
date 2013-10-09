package intMonitorWeb.Ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import tn.intt.intMonitor.dao.inter.LogsDaoRemote;
import tn.intt.intMonitor.entities.Logs;


@SessionScoped
@ManagedBean
public class LogsCtrl {
	
	@EJB 
	private LogsDaoRemote logsDaoRemote;
	
	//Models
	private Logs log=new Logs();
	private List<Logs> listLogs=new ArrayList<Logs>();
	private DataModel<Logs> modelLogs= new ListDataModel<Logs>();
	private Logs selectLogs= new Logs();
	
	//methode
	
	public String selectLogs()
	{
		selectLogs = modelLogs.getRowData();
		return "updateUser";
	}
	
	public Logs getSelectLogs() {
		return selectLogs;
	}
	public void setSelectLogs(Logs selectLogs) {
		this.selectLogs = selectLogs;
	}
	
	public Logs getLog() {
		return log;
	}
	
	public void setLog(Logs log) {
		this.log = log;
	}
	
	public List<Logs> getListLogs() {
		listLogs = logsDaoRemote.getAllLogs();
		return listLogs;
	}
	public void setListLogs(List<Logs> listLogs) {
		this.listLogs = listLogs;
	}
	
	public DataModel<Logs> getModelLogs() {
		modelLogs.setWrappedData(logsDaoRemote.getAllLogs());
		return modelLogs;
	}
	public void setModelLogs(DataModel<Logs> modelLogs) {
		this.modelLogs = modelLogs;
	}
	
	

}
