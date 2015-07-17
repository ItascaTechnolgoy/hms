package in.co.itasca.hms.persistence.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;


/**
 * The persistent class for the testregistration database table.
 * 
 */
@Entity
@NamedQuery(name="Testregistration.findAll", query="SELECT t FROM Testregistration t")
public class Testregistration implements IDBEntity, Serializable {
	private static final long serialVersionUID = 1L;
	public static  final String ID="Id";
	public static final String IDRATESMASTER="IdRatesMaster";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idtestRecommended;

	//bi-directional many-to-one association to Testratesmaster
	@ManyToOne
	private Testratesmaster testratesmaster;

	public Testregistration() {
	}

	public int getIdtestRecommended() {
		return this.idtestRecommended;
	}

	public void setIdtestRecommended(int idtestRecommended) {
		this.idtestRecommended = idtestRecommended;
	}

	public Testratesmaster getTestratesmaster() {
		return this.testratesmaster;
	}

	public void setTestratesmaster(Testratesmaster testratesmaster) {
		this.testratesmaster = testratesmaster;
	}

	@Override
	public Map<String, Object> convertModelTOEDM() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
		
		
		map.put(ID,idtestRecommended);
		map.put(IDRATESMASTER,testratesmaster.getIdtestrates());
		return map;
		} catch (Exception e) {
			return null;	}
		
		}

	}

 