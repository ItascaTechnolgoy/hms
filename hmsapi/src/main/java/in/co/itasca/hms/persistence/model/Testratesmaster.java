package in.co.itasca.hms.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The persistent class for the testratesmaster database table.
 * 
 */
@Entity
@NamedQuery(name="Testratesmaster.findAll", query="SELECT t FROM Testratesmaster t")
public class Testratesmaster implements IDBEntity, Serializable {
	private static final long serialVersionUID = 1L;

	public static final String ID="Id";
	public static final String IDTESTMASTER="IdTestMaster";
	public static final String IDPATIENTCATEGORYMASTER="IdPatientCategoryMaster";
	public static final String VALIDFROM="validFrom";
	public static final String VALIDTO="validTo";
	public static final String RATE="rate";
	public static final String ACTIVE="active";


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idtestrates;

	private float rate;

	@Temporal(TemporalType.DATE)
	private Date validFrom;

	@Temporal(TemporalType.DATE)
	private Date validTo;

	//bi-directional many-to-one association to Patientscategorymaster
	@ManyToOne
	@JoinColumn(name="patientsType_idpatientsType")
	private Patientscategorymaster patientscategorymaster;

	//bi-directional many-to-one association to Testmaster
	@ManyToOne
	@JoinColumn(name="tests_idtests")
	private Testmaster testmaster;

	//bi-directional many-to-one association to Testregistration
	@OneToMany(mappedBy="testratesmaster")
	private List<Testregistration> testregistrations;

	public Testratesmaster() {
	}

	public int getIdtestrates() {
		return this.idtestrates;
	}

	public void setIdtestrates(int idtestrates) {
		this.idtestrates = idtestrates;
	}

	public float getRate() {
		return this.rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
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

	public Patientscategorymaster getPatientscategorymaster() {
		return this.patientscategorymaster;
	}

	public void setPatientscategorymaster(Patientscategorymaster patientscategorymaster) {
		this.patientscategorymaster = patientscategorymaster;
	}

	public Testmaster getTestmaster() {
		return this.testmaster;
	}

	public void setTestmaster(Testmaster testmaster) {
		this.testmaster = testmaster;
	}

	public List<Testregistration> getTestregistrations() {
		return this.testregistrations;
	}

	public void setTestregistrations(List<Testregistration> testregistrations) {
		this.testregistrations = testregistrations;
	}

	public Testregistration addTestregistration(Testregistration testregistration) {
		getTestregistrations().add(testregistration);
		testregistration.setTestratesmaster(this);

		return testregistration;
	}

	public Testregistration removeTestregistration(Testregistration testregistration) {
		getTestregistrations().remove(testregistration);
		testregistration.setTestratesmaster(null);

		return testregistration;
	}

	@Override
	public Map<String, Object> convertModelTOEDM() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
		
//		map.put(ACTIVE, get)
			map.put(ID, getIdtestrates());
			map.put(IDPATIENTCATEGORYMASTER, getPatientscategorymaster().getIdpatientsType());
			map.put(IDTESTMASTER, getTestmaster().getIdtests());
			map.put(RATE, getRate());
			map.put(VALIDFROM, getValidFrom());
			map.put(VALIDTO	, getValidTo());
		 	 	return map;
		} catch (Exception e) {
			return null;	}
		
		}
	
	}










