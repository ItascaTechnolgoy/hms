package in.co.itasca.hms.persistence.dao;

import in.co.itasca.hms.persistence.manager.EntityManagerProvider;
import in.co.itasca.hms.persistence.manager.PersistenceManager;
import in.co.itasca.hms.persistence.model.Testratesmaster;

public class TestRatesMasterDAO extends BasicDAO<Testratesmaster>{

	public TestRatesMasterDAO(EntityManagerProvider emProvider) {
		super(PersistenceManager.getInstance().getEntityManagerProvider());

	}

}
