package in.co.itasca.hms.api.service;

import in.co.itasca.hms.persistence.dao.TestRegistrationDAO;
import in.co.itasca.hms.persistence.dao.UsersDAO;
import in.co.itasca.hms.persistence.model.Testregistration;
import in.co.itasca.hms.persistence.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestRegistrationService extends BaseService{

	public TestRegistrationService(String role) {
		super(role);
		super.idao = new TestRegistrationDAO();
	}

	@Override
	public List<Map<String, Object>> getRecords() {
try {
			
			
			List<Map<String, Object>> collection = new ArrayList<Map<String, Object>>();
			TestRegistrationDAO dao = (TestRegistrationDAO) idao;
					
			List<Testregistration> list =dao.getAll();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Testregistration entity = (Testregistration) iterator.next();
				collection.add(entity.convertModelTOEDM());
			}
			 return collection;
			} catch (Exception e) {
			return  null;
			}
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
