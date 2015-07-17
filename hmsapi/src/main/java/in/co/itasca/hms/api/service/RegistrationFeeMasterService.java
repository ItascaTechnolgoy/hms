package in.co.itasca.hms.api.service;

import in.co.itasca.hms.persistence.dao.RegistrationFeeMasterDAO;

import java.util.List;
import java.util.Map;

public class RegistrationFeeMasterService extends BaseService {

	

	public RegistrationFeeMasterService(String role) {
		super(role);
		super.idao= new RegistrationFeeMasterDAO();
	}

	@Override
	public List<Map<String, Object>> getRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getAssociation(int id, String associatedEdm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getRecord(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
