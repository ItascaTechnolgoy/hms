package in.co.itasca.hms.api.service;

import in.co.itasca.hms.persistence.dao.PatientCategoryMasterDAO;

import java.util.List;
import java.util.Map;

public class PatientCategoryMasterService extends BaseService{
	
	public static final String ID="Id";
	public static final String PATIENTTYPENAME="patientTypeName";
	public static final String PATIENTTYPEDESCRIPTION="patientTypeDescription";
	public static final String CREATEDBY="createdBy";
    public static final String CREATEDON="createdOn";
    public static final String CHANGEDBY="changedBy";
    public static final String CHANGEDON="changedOn";
    public static final String ACTIVE="active";


	public PatientCategoryMasterService(String role) {
		super(role);
		super.idao= new PatientCategoryMasterDAO();
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
