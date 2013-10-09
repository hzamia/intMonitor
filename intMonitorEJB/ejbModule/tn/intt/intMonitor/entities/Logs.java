package tn.intt.intMonitor.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: logs
 *
 */
@Entity
@Table(name="logs")
public class Logs implements Serializable {

	   
	
	private int seq;
	private String msg;
	private String program;
	private String tag;
	private String level;
	private Date datetime;
	private String priority;
	private String facility;
	private String host;
	private static final long serialVersionUID = 1L;

	public Logs() {
		super();
	}   
	
	@Id
	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}   
	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}   
	public String getProgram() {
		return this.program;
	}

	public void setProgram(String program) {
		this.program = program;
	}   
	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}   
	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}   
	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}   
	public String getFacility() {
		return this.facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}   
	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

    @Temporal(TemporalType.TIMESTAMP)
	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
   
}
