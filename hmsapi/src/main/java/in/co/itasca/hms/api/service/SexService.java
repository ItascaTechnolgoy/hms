package in.co.itasca.hms.api.service;

import in.co.itasca.hms.persistence.dao.SexDAO;
import in.co.itasca.hms.persistence.dao.UsersDAO;
import in.co.itasca.hms.persistence.model.Sex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SexService extends BaseService {

	public SexService(String role) {
		super(role);
		super.idao = new SexDAO();
	}

	@Override
	public List<Map<String, Object>> getRecords() {
		SexDAO dao = (SexDAO) idao;
		List<Sex> sexs = dao.getAll();
		 List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		for (Iterator iterator = sexs.iterator(); iterator.hasNext();) {
			Sex sex = (Sex) iterator.next();
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("Id",new Integer(sex.getIdsex()));
			data.put("sexText", sex.getSexText());
		data.put("createdBy", sex.getCreatedBy());
 		data.put("createdOn", sex.getCreatedOn());
 			data.put("changedBy", (sex.getChangedBy()==null)?"NONE":sex.getChangedBy());
		data.put("changedOn", (sex.getChangedOn()==null?"NONE": sex.getChangedOn()));
			data.put("active",sex.getActive() );
			list.add(data);
		}


		    return list;
	}

	@Override
	public List<Map<String, Object>> getAssociation(int id, String associatedEdm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getRecord(int id) {
 
		return null;
	}

	Map<String, Object> createSex(int id, String sexName, String createdBy){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("Id", id);
		data.put("sexText", sexName);
		data.put("createdBy", createdBy);
		return data;
	}
}
