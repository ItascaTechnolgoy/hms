package in.co.itasca.hms.api.service;

import in.co.itasca.hms.persistence.dao.RolesDAO;

import java.util.List;
import java.util.Map;

public class RolesService extends BaseService {
	

	public RolesService(String role) {
		super(role);
		super.idao= new RolesDAO();
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
