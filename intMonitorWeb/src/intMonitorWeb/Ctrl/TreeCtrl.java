package intMonitorWeb.Ctrl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.MenuModel;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.DonutChartModel;

import tn.intt.intMonitor.dao.inter.LoggingDaoRemote;
import tn.intt.intMonitor.entities.Logging;

@SessionScoped
@ManagedBean
public class TreeCtrl {

	@EJB
	private LoggingDaoRemote loggingDaoRemote;

	private String page = "welcome";
	private MenuModel model;
	private String priority;
	private String host;

	
	
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void user(ActionEvent actionEvent) {
		setPage("manageuser");
	}

	public void equip(ActionEvent actionEvent) {
		setPage("equipements");
	}

	public void logs(ActionEvent actionEvent) {
		setPage("listlog");
	}

	public void activeDirectory(ActionEvent actionEvent) {
		setPage("192.168.16.4");
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public List<Logging> getfacilityByHost() {
		return loggingDaoRemote.getPriorityByHost(priority, host);
	}

	private BubbleChartModel bubbleModel;

	@PostConstruct
	public void init() {
		createDonutModel();

	}

	public BubbleChartModel getBubbleModel() {
		return bubbleModel;
	}

	public void setBubbleModel(BubbleChartModel bubbleModel) {
		this.bubbleModel = bubbleModel;
	}

	private void createBubbleModel() {
		bubbleModel = new BubbleChartModel();

		bubbleModel.add(new BubbleChartSeries("Acura", 70, 183, 55));
		bubbleModel.add(new BubbleChartSeries("Alfa Romeo", 45, 92, 36));
		bubbleModel.add(new BubbleChartSeries("AM General", 24, 104, 40));
		bubbleModel.add(new BubbleChartSeries("Bugatti", 50, 123, 60));
		bubbleModel.add(new BubbleChartSeries("BMW", 15, 89, 25));
		bubbleModel.add(new BubbleChartSeries("Audi", 40, 180, 80));
		bubbleModel.add(new BubbleChartSeries("Aston Martin", 70, 70, 48));
	}

	private DonutChartModel donutModel;

	public DonutChartModel getDonutModel() {
		return donutModel;
	}

	private void createDonutModel() {
		donutModel = new DonutChartModel();

		Map<String, Number> circle1 = new LinkedHashMap<String, Number>();
		
		setPriority("notice");
		setHost("root.intt.tn");
		if(getfacilityByHost().size()!=0)
		circle1.put("notice", getfacilityByHost().size());
		
		setPriority("emerg");
		setHost("root.intt.tn");
		if(getfacilityByHost().size()!=0)
		circle1.put("Emergency", getfacilityByHost().size());

		setPriority("alert");
		setHost("root.intt.tn");
		if(getfacilityByHost().size()!=0)
		circle1.put("Alert", getfacilityByHost().size());
		
		
		setPriority("crit");
		setHost("root.intt.tn");
		if(getfacilityByHost().size()!=0)
		circle1.put("Critical", getfacilityByHost().size());
		
		setPriority("err");
		setHost("root.intt.tn");
		if(getfacilityByHost().size()!=0)
		circle1.put("error", getfacilityByHost().size());
		
		setPriority("warning");
		setHost("root.intt.tn");
		if(getfacilityByHost().size()!=0)
		circle1.put("Warning", getfacilityByHost().size());
		
		setPriority("info");
		setHost("root.intt.tn");
		if(getfacilityByHost().size()!=0)
		circle1.put("Info", getfacilityByHost().size());
		
		setPriority("debug");
		setHost("root.intt.tn");
		if(getfacilityByHost().size()!=0)
		circle1.put("Debug", getfacilityByHost().size());
		
		donutModel.addCircle(circle1);
	}

	public void setDonutModel(DonutChartModel donutModel) {
		this.donutModel = donutModel;
	}

}
