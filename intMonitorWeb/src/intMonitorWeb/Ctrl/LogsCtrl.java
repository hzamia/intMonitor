package intMonitorWeb.Ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.primefaces.model.chart.PieChartModel;

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
	private DataModel<Logging> modelLogsHost = new ListDataModel<Logging>();
	private DataModel<Logging> modelHost = new ListDataModel<Logging>();
	
	
	

	private String host;
	public String priority;
	private PieChartModel pieChartModel;

    
    
	//methode
	
	public LogsCtrl() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init()
	{
		createChart();
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

	public DataModel<Logging> getModelLogsHost() {
		modelLogsHost.setWrappedData(logsDaoRemote.getHostLog());
		return modelLogsHost;
	}

	public void setModelLogsHost(DataModel<Logging> modelLogsHost) {
		this.modelLogsHost = modelLogsHost;
	}

	
	public Long getFacilityCount()
	{
		return logsDaoRemote.getPriorityCount(priority);
	}

	public String getFacility() {
		return priority;
	}

	public void setPriority(String facility) {
		this.priority = facility;
	}

	public PieChartModel getPieChartModel() {
		return pieChartModel;
	}

	public void setPieChartModel(PieChartModel pieChartModel) {
		this.pieChartModel = pieChartModel;
	}
	
	
	
	
	public void createChart()
	{
		pieChartModel=new PieChartModel();
		
		setPriority("emerg");
		Long emerg= getFacilityCount();
		if(emerg!=0)
		pieChartModel.set("Emergency", emerg);
		
		
		setPriority("Alert");
		Long alert= getFacilityCount();
		if(alert!=0)
		pieChartModel.set("Alert",alert);

		setPriority("crit");
		Long crit= getFacilityCount();
		if(crit!=0)
		pieChartModel.set("Critical", crit);
		
		setPriority("err");
		Long err= getFacilityCount();
		if(err!=0)
		pieChartModel.set("error",err);
		
		setPriority("warning");
		Long warning= getFacilityCount();
		if(warning!=0)
		pieChartModel.set("Warning",warning);
		
		
		setPriority("notice");
		Long notice= getFacilityCount();
		if(notice!=0)
		pieChartModel.set("Notice",notice);
		
		setPriority("info");
		Long info= getFacilityCount();
		if(info!=0)
		pieChartModel.set("Information",info);
		
		setPriority("debug");
		Long debug= getFacilityCount();
		if(debug!=0)
		pieChartModel.set("Debug",debug);
		
	}
	
	

	public DataModel<Logging> getModelHost() {
		modelHost.setWrappedData(logsDaoRemote.getlistHosts());
		return modelHost;
	}
	
	
	
	
	
	
	public void setModelHost(DataModel<Logging> modelHost) {
		this.modelHost = modelHost;
	}

	
		
	//Get count/Logs par type AD
	public int getCountOthersAd()
	{
		return logsDaoRemote.getlogsOthersAd().size();
	}

	public int getCountLogOnAd()
	{
		return logsDaoRemote.getLogsSuccessLoginAd().size();
	}
	
	public int getCountLogOffAd()
	{
		return logsDaoRemote.getLogsLogOffAd().size();
	}
	

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}








	
	
}
