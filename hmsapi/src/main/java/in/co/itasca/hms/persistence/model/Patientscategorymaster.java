package in.co.itasca.hms.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The persistent class for the patientscategorymaster database table.
 * 
 */
@Entity
@NamedQuery(name="Patientscategorymaster.findAll", query="SELECT p FROM Patientscategorymaster p")
public class Patientscategorymaster implements IDBEntity, Serializable {
	 

	public static final String ID="Id";
	public static final String PATIENTTYPENAME="patientTypeName";
	public static final String PATIENTTYPEDESCRIPTION="patientTypeDescription";
	public static final String CREATEDBY="createdBy";
    public static final String CREATEDON="createdOn";
    public static final String CHANGEDBY="changedBy";
    public static final String CHANGEDON="changedOn";
    public static final String ACTIVE="active";

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idpatientsType;

	private byte active;

	private String changedBy;

	@Temporal(TemporalType.DATE)
	private Date changedOn;

	private String createdBy;

	@Temporal(TemporalType.DATE)
	private Date createdOn;

	private String patientsTypeDescription;

	private String patientTypeName;

	//bi-directional many-to-one association to Registrationfeemaster
	@OneToMany(mappedBy="patientscategorymaster")
	private List<Registrationfeemaster> registrationfeemasters;

	//bi-directional many-to-one association to Testratesmaster
	@OneToMany(mappedBy="patientscategorymaster")
	private List<Testratesmaster> testratesmasters;

	public Patientscategorymaster() {
	}

	public int getIdpatientsType() {
		return this.idpatientsType;
	}

	public void setIdpatientsType(int idpatientsType) {
		this.idpatientsType = idpatientsType;
	}

	public byte getActive() {
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

	public String getPatientsTypeDescription() {
		return this.patientsTypeDescription;
	}

	public void setPatientsTypeDescription(String patientsTypeDescription) {
		this.patientsTypeDescription = patientsTypeDescription;
	}

	public String getPatientTypeName() {
		return this.patientTypeName;
	}

	public void setPatientTypeName(String patientTypeName) {
		this.patientTypeName = patientTypeName;
	}

	public List<Registrationfeemaster> getRegistrationfeemasters() {
		return this.registrationfeemasters;
	}

	public void setRegistrationfeemasters(List<Registrationfeemaster> registrationfeemasters) {
		this.registrationfeemasters = registrationfeemasters;
	}

	public Registrationfeemaster addRegistrationfeemaster(Registrationfeemaster registrationfeemaster) {
		getRegistrationfeemasters().add(registrationfeemaster);
		registrationfeemaster.setPatientscategorymaster(this);

		return registrationfeemaster;
	}

	public Registrationfeemaster removeRegistrationfeemaster(Registrationfeemaster registrationfeemaster) {
		getRegistrationfeemasters().remove(registrationfeemaster);
		registrationfeemaster.setPatientscategorymaster(null);

		return registrationfeemaster;
	}

	public List<Testratesmaster> getTestratesmasters() {
		return this.testratesmasters;
	}

	public void setTestratesmasters(List<Testratesmaster> testratesmasters) {
		this.testratesmasters = testratesmasters;
	}

	public Testratesmaster addTestratesmaster(Testratesmaster testratesmaster) {
		getTestratesmasters().add(testratesmaster);
		testratesmaster.setPatientscategorymaster(this);

		return testratesmaster;
	}

	public Testratesmaster removeTestratesmaster(Testratesmaster testratesmaster) {
		getTestratesmasters().remove(testratesmaster);
		testratesmaster.setPatientscategorymaster(null);

		return testratesmaster;
	}

	@Override
	public Map<String, Object> convertModelTOEDM() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
		
		map.put(ACTIVE, (active==1)? true : false);
		map.put(CHANGEDBY, (changedBy!=null)?changedBy: "");
		map.put(CREATEDBY, createdBy);
		map.put(CREATEDON, createdOn);
		map.put(ID, idpatientsType);
		map.put(PATIENTTYPEDESCRIPTION, patientsTypeDescription);
		return map;
		} catch (Exception e) {
			return null;	}
		
		}
	}

