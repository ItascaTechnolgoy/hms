package in.co.itasca.hms.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements IDBEntity,Serializable {
	private static final long serialVersionUID = 1L;
	public static final String USERNAME="userName";
	public static final String PASSWORD="password";
	public static final String MOBILENO="mobileNo";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String username;

	private String email;

	private String password;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="users_roles"
		, joinColumns={
			@JoinColumn(name="username")
			}
		, inverseJoinColumns={
			@JoinColumn(name="rolename")
			}
		)
	private List<Role> roles;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Map<String, Object> convertModelTOEDM() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
		
		
		map.put(USERNAME, getUsername());
		map.put(PASSWORD, getPassword());
//		map.put(MOBILENO, get)
	 	return map;
		} catch (Exception e) {
			return null;	}
		
		}
}