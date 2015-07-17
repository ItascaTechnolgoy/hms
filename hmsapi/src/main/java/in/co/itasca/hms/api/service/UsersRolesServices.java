package in.co.itasca.hms.api.service;

import in.co.itasca.hms.persistence.dao.UsersRolesDAO;

import java.util.List;
import java.util.Map;

public class UsersRolesServices extends BaseService{

	public UsersRolesServices(String role) {
		super(role);
//		super.idao= new UsersRolesDAO();
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
