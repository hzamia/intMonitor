package intMonitorWeb.Ctrl;



import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
 
@ManagedBean
@SessionScoped
public class ChartBean implements Serializable {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CartesianChartModel categoryModel;  
  
	public ChartBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init()
	{
		createChartBar();
	}
	
	
  
    public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    }  
  
    
    private void createChartBar() {  
    	
        categoryModel = new CartesianChartModel();  
  
        ChartSeries boys = new ChartSeries();  
        boys.setLabel("Boys");  
  
        boys.set("2004", 120);  
        boys.set("2005", 100);  
        boys.set("2006", 44);  
        boys.set("2007", 150);  
        boys.set("2008", 25);  
  
        ChartSeries girls = new ChartSeries();  
        girls.setLabel("Girls");  
  
        girls.set("2004", 52);  
        girls.set("2005", 60);  
        girls.set("2006", 110);  
        girls.set("2007", 135);  
        girls.set("2008", 120);  
  
        categoryModel.addSeries(boys);  
        categoryModel.addSeries(girls);  
    }  
}  