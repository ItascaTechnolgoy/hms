package in.co.itasca.hms.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.Map;


/**
 * The persistent class for the registration database table.
 * 
 */
@Entity
@NamedQuery(name="Registration.findAll", query="SELECT r FROM Registration r")
public class Registration implements IDBEntity, Serializable {
	
	public static final String ID="Id";
	public static final String NAME="Name";
	public static final String AGE="Age";
	public static final String AGEINWORDS="AgeInWords";
	public static final String VALIDFROM="ValidFrom";
	public static final String VALIDTO="validTo";
	public static final String CREATEDBY="CreatedBy";
	public static final String CREATEDON="CreatedOn";
	public static final String CHANGEDBY="ChangedBy";
	public static final String CHANGEDON="ChangedOn";
	public static final String PRICE="price";
	public static final String ACTIVE="active";
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idregistration;

	private byte active;

	@Temporal(TemporalType.DATE)
	private Date agedate;

	private String agein;

	private String changedBy;

	@Temporal(TemporalType.DATE)
	private Date changedOn;

	private String createdBy;

	@Temporal(TemporalType.DATE)
	private Date createdOn;

	private String name;

	private float price;

	@Temporal(TemporalType.DATE)
	private Date validFrom;

	@Temporal(TemporalType.DATE)
	private Date validTo;

	//bi-directional many-to-one association to Registrationfeemaster
	@ManyToOne
	private Registrationfeemaster registrationfeemaster;

	//bi-directional many-to-one association to Department
	@ManyToOne
	private Department department;

	//bi-directional many-to-one association to Sex
	@ManyToOne
	@JoinColumn(name="sex")
	private Sex sexBean;

	public Registration() {
	}

	public int getIdregistration() {
		return this.idregistration;
	}

	public void setIdregistration(int idregistration) {
		this.idregistration = idregistration;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getAgedate() {
		return this.agedate;
	}

	public void setAgedate(Date agedate) {
		this.agedate = agedate;
	}

	public String getAgein() {
		return this.agein;
	}

	public void setAgein(String agein) {
		this.agein = agein;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Registrationfeemaster getRegistrationfeemaster() {
		return this.registrationfeemaster;
	}

	public void setRegistrationfeemaster(Registrationfeemaster registrationfeemaster) {
		this.registrationfeemaster = registrationfeemaster;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Sex getSexBean() {
		return this.sexBean;
	}

	public void setSexBean(Sex sexBean) {
		this.sexBean = sexBean;
	}

	@Override
	public Map<String, Object> convertModelTOEDM() {
		// TODO Auto-generated method stub
		return null;
	}

}