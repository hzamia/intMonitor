package tn.intt.intMonitor.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Logging
 *
 */
@Entity
@Table(name="logs")
public class Logging implements Serializable {

	
	private int seq;
	private String msg;
	private String tag;
	private String level;
	private Date datetime;
	private String priority;
	private String facility;
	private String host;
	private String program;
	//private EquipRx equipRx;
	private static final long serialVersionUID = 1L;

	public Logging() {
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
	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
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
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	/*@ManyToOne
	public EquipRx getEquipRx() {
		return equipRx;
	}
	public void setEquipRx(EquipRx equipRx) {
		this.equipRx = equipRx;
	}
   */
}
