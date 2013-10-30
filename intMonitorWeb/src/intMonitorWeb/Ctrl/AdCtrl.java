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
public class AdCtrl {
	
	@EJB 
	private LoggingDaoRemote logsDaoRemote;
	
	//Models
	
	private DataModel<Logging> modelLoginAd = new ListDataModel<Logging>();
	private DataModel<Logging> modelLogOffAd= new ListDataModel<Logging>();
	private DataModel<Logging> modelOthersAd= new ListDataModel<Logging>();
	private DataModel<Logging> modelLogHostAd= new ListDataModel<Logging>();
	private DataModel<Logging> modelPriorityByHost= new ListDataModel<Logging>(); 
	private List<Logging> listlogsAd= new ArrayList<Logging>();
	
	private int loginAd;
	private int logOffAd;
	private int otherAd;
	
	
	private String host;
	private String priority;
	
	private PieChartModel pieChartAd;

	
	//Methodes
	
	@PostConstruct
	public void init()
	{
		createChartAd();
	}

	public List<Logging> getfacilityByHost()
	{
		return logsDaoRemote.getPriorityByHost(priority, host);
	}
	
	public void createChartAd()
	{
		setPieChartAd(new PieChartModel());
		
		setHost("root.intt.tn");
		
		setPriority("emerg");
		int emerg= getfacilityByHost().size();
		if(emerg!=0)
		pieChartAd.set("Emergency", emerg);
		
		
		setPriority("Alert");
		int alert= getfacilityByHost().size();
		if(alert!=0)
		pieChartAd.set("Alert",alert);

		setPriority("crit");
		int crit= getfacilityByHost().size();
		if(crit!=0)
		pieChartAd.set("Critical", crit);
		
		setPriority("err");
		int err= getfacilityByHost().size();
		if(err!=0)
		pieChartAd.set("error",err);
		
		setPriority("warning");
		int warning= getfacilityByHost().size();
		if(warning!=0)
		pieChartAd.set("Warning",warning);
	
		
		setPriority("notice");
		int notice= getfacilityByHost().size();
		if(notice!=0)
		pieChartAd.set("Notice",notice);
		
		setPriority("info");
		int info= getfacilityByHost().size();
		if(info!=0)
		pieChartAd.set("Information",info);
		
		setPriority("debug");
		int debug= getfacilityByHost().size();
		if(debug!=0)
		pieChartAd.set("Debug",debug);
		
	}
	
	public List<Logging> getListLogsAd()
	{
		setHost("root.intt.tn");
		listlogsAd = logsDaoRemote.getLogsByHost(host);
		return listlogsAd;
	}
	
	
	public List<Logging> getListlogsAd() {
		return listlogsAd;
	}

	public void setListlogsAd(List<Logging> listlogsAd) {
		this.listlogsAd = listlogsAd;
	}
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public DataModel<Logging> getLogsSessionAd()
	{
		modelLoginAd.setWrappedData(logsDaoRemote.getLogsSuccessLoginAd());
		return modelLoginAd;
	}
	
	public DataModel<Logging> getLogsOffAd()
	{
		modelLogOffAd.setWrappedData(logsDaoRemote.getLogsLogOffAd());
		return modelLogOffAd;
	}
	
	public DataModel<Logging> getOthersAd()
	{
		modelOthersAd.setWrappedData(logsDaoRemote.getlogsOthersAd());
		return modelOthersAd;
	}
	
	
	public DataModel<Logging> getModelLoginAd() {
		return modelLoginAd;
	}

	public void setModelLoginAd(DataModel<Logging> modelLoginAd) {
		this.modelLoginAd = modelLoginAd;
	}
	
	public DataModel<Logging> getLogsAd()
	{
		setHost("root.intt.tn");
		modelLogHostAd.setWrappedData(logsDaoRemote.getLogsByHost(host));
		System.out.println(host);
		return modelLogHostAd;
	}
	
	
	public DataModel<Logging> getModelLogOffAd() {
		return modelLogOffAd;
	}

	public void setModelLogOffAd(DataModel<Logging> modelLogOffAd) {
		this.modelLogOffAd = modelLogOffAd;
	}

	public DataModel<Logging> getModelOthersAd() {
		return modelOthersAd;
	}

	public void setModelOthersAd(DataModel<Logging> modelOthersAd) {
		this.modelOthersAd = modelOthersAd;
	}

	public DataModel<Logging> getModelLogHostAd() {
		return modelLogHostAd;
	}

	public void setModelLogHostAd(DataModel<Logging> modelLogHostAd) {
		this.modelLogHostAd = modelLogHostAd;
	}  
	
	
	public int getLoginAd() {
		return loginAd;
	}

	public void setLoginAd(int loginAd) {
		this.loginAd = loginAd;
	}

	public int getLogOffAd() {
		return logOffAd;
	}

	public void setLogOffAd(int logOffAd) {
		this.logOffAd = logOffAd;
	}

	public int getOtherAd() {
		return otherAd;
	}

	public void setOtherAd(int otherAd) {
		this.otherAd = otherAd;
	}
	
	public DataModel<Logging> getModelPriorityByHost() {
		return modelPriorityByHost;
	}

	public void setModelprioritybyHost(DataModel<Logging> modelPriorityByHost) {
		this.modelPriorityByHost = modelPriorityByHost;
	}

	public PieChartModel getPieChartAd() {
		return pieChartAd;
	}

	public void setPieChartAd(PieChartModel pieChartAd) {
		this.pieChartAd = pieChartAd;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
}
