package in.co.itasca.hms.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.internal.sessions.remote.SequencingFunctionCall.GetNextValue;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The persistent class for the registrationfeemaster database table.
 * 
 */
@Entity
@NamedQuery(name="Registrationfeemaster.findAll", query="SELECT r FROM Registrationfeemaster r")
public class Registrationfeemaster implements IDBEntity, Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String ID="Id";
	public static final String NAME="Name";
	public static final String FEE="fee";
	public static final String CREATEDON="createdOn";
	public static final String CREATEDBY="createdBy";
	public static final String ACTIVE="active";
	public static final String APPROVEDBY="approvedBy";
	public static final String APPROVEDON="approvedby";
	public static final String VALIDITYDAYS="validityDays";
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String approvedBy;

	@Temporal(TemporalType.DATE)
	private Date approvedOn;

	private String createdBy;

	@Temporal(TemporalType.DATE)
	private Date createdOn;

	private float fee;

	private int validityDays;

	//bi-directional many-to-one association to Registration
	@OneToMany(mappedBy="registrationfeemaster")
	private List<Registration> registrations;

	//bi-directional many-to-one association to Patientscategorymaster
	@ManyToOne
	private Patientscategorymaster patientscategorymaster;

	public Registrationfeemaster() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovedOn() {
		return this.approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
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

	public float getFee() {
		return this.fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public int getValidityDays() {
		return this.validityDays;
	}

	public void setValidityDays(int validityDays) {
		this.validityDays = validityDays;
	}

	public List<Registration> getRegistrations() {
		return this.registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public Registration addRegistration(Registration registration) {
		getRegistrations().add(registration);
		registration.setRegistrationfeemaster(this);

		return registration;
	}

	public Registration removeRegistration(Registration registration) {
		getRegistrations().remove(registration);
		registration.setRegistrationfeemaster(null);

		return registration;
	}

	public Patientscategorymaster getPatientscategorymaster() {
		return this.patientscategorymaster;
	}

	public void setPatientscategorymaster(Patientscategorymaster patientscategorymaster) {
		this.patientscategorymaster = patientscategorymaster;
	}

	@Override
	public Map<String, Object> convertModelTOEDM() {
		 Map<String, Object> data = new HashMap<String, Object>();
		 try {
		 	
		 	data.put(ID,getId());
		 	data.put(APPROVEDBY, getApprovedBy());
		 	data.put(APPROVEDON, getApprovedOn());
		 	data.put(CREATEDBY, getCreatedBy());
		 	data.put(CREATEDON, getCreatedOn());
		 	data.put(FEE, getFee());
//		 	data.put(NAME, ge)
		 	data.put(VALIDITYDAYS, getValidityDays());
		 	
		 	
		 	
		 	
		 	
		 	
		     return data;
		 } catch (Exception e) {
		 return null;
		 }
}
}