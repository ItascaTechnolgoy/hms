package in.co.itasca.hms.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements IDBEntity, Serializable {
	private static final long serialVersionUID = 1L;

	public static final String ROLENAME="roleName";
	public static final String ROLEDESCRIPTION="roleDescription";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String rolename;

	private String roledescription;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="roles")
	private List<User> users;

	public Role() {
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledescription() {
		return this.roledescription;
	}

	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public Map<String, Object> convertModelTOEDM() {
		 Map<String, Object> data = new HashMap<String, Object>();
		 try {
		 	
		 	data.put(ROLENAME, getRolename());
		 	data.put(ROLEDESCRIPTION, getRoledescription());
		 	 
		 	
		 	
		 	
		 	
		     return data;
		 } catch (Exception e) {
		 return null;
		 }
	}
}