package intMonitorWeb.Ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import tn.intt.intMonitor.dao.inter.LoggingDaoRemote;
import tn.intt.intMonitor.entities.Logging;


@SessionScoped
@ManagedBean
public class LogsCtrl {
	
	@EJB 
	private LoggingDaoRemote logsDaoRemote;
	
	//Models
	private Logging log=new Logging();
	private List<Logging> listLogs=new ArrayList<Logging>();
	private DataModel<Logging> modelLogs= new ListDataModel<Logging>();
	private Logging selectLogs= new Logging();
	
	//methode
	
	public String selectLogs()
	{
		selectLogs = modelLogs.getRowData();
		return "updateUser";
	}
	
	public Logging getSelectLogs() {
		return selectLogs;
	}
	public void setSelectLogs(Logging selectLogs) {
		this.selectLogs = selectLogs;
	}
	
	public Logging getLog() {
		return log;
	}
	
	public void setLog(Logging log) {
		this.log = log;
	}
	
	public List<Logging> getListLogs() {
		listLogs = logsDaoRemote.getAllLogs();
		return listLogs;
	}
	public void setListLogs(List<Logging> listLogs) {
		this.listLogs = listLogs;
	}
	
	public DataModel<Logging> getModelLogs() {
		modelLogs.setWrappedData(logsDaoRemote.getAllLogs());
		return modelLogs;
	}
	public void setModelLogs(DataModel<Logging> modelLogs) {
		this.modelLogs = modelLogs;
	}
	
	

}
