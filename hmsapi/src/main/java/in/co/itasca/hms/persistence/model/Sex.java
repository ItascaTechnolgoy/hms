package in.co.itasca.hms.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * The persistent class for the sex database table.
 * 
 */
@Entity
@NamedQuery(name="Sex.findAll", query="SELECT s FROM Sex s")
public class Sex implements Serializable, IDBEntity {
	private static final long serialVersionUID = 1L;

	private static final String ID ="Id";
	private static final String SEXTEXT ="sexText";
	private static final String CREATEDBY ="createdBy";
	private static final String CREATEDON ="createdOn";
	private static final String CHANGEDBY ="changedBy";
	private static final String CHANGEDON ="changedOn";
	private static final String ACTIVE = "active";
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idsex;

	private int active;

	private String changedBy;

	@Temporal(TemporalType.DATE)
	private Date changedOn;

	private String createdBy;

	@Temporal(TemporalType.DATE)
	private Date createdOn;

	private String sexText;

	public Sex() {
	}

	public int getIdsex() {
		return this.idsex;
	}

	public void setIdsex(int idsex) {
		this.idsex = idsex;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Date getChangedOn() {
		return this.changedOn;
	}

	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getSexText() {
		return this.sexText;
	}

	public void setSexText(String sexText) {
		this.sexText = sexText;
	}

	@Override
	public Map<String, Object> convertModelTOEDM() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
		
		map.put(ACTIVE, (getActive()==1)? true : false);
		map.put(CHANGEDBY, (getChangedBy()!=null)?changedBy: "");
		map.put(CREATEDBY, getCreatedBy());
		map.put(CREATEDON, getCreatedOn());
		map.put(ID, getIdsex()  );
		map.put(SEXTEXT, getSexText());
		return map;
		} catch (Exception e) {
			return null;	}
		
		}
	
	}

