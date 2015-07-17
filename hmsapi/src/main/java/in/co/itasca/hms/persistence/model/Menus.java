package in.co.itasca.hms.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The persistent class for the menus database table.
 * 
 */
@Entity
@Table(name="menus")
@NamedQueries({
@NamedQuery(name="Menus.findAll", query="SELECT m FROM Menus m")
,
@NamedQuery(name="Menus.getMenusFromRoot", query="SELECT m FROM Menus m where m.fkId is NULL")
})
public class Menus implements Serializable, IDBEntity {
	
	private static final String ID ="Id";
	private static final String TITLE ="title";
	private static final String  INFO ="info";
	private static final String NUMBER ="number";
	private static final String NUMBERUNIT="numberUnit";
	private static final String ICON ="icon";
	private static final String TARGETPAGE = "targetPage";
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String icon;

	private String info;

	private String menukey;

	private String menunumber;

	private String numberunit;

	private String title;

	@Column(name="Menus_id", nullable=true, updatable= false, insertable=false)
	private int fkId;
	
	
	//bi-directional many-to-one association to Menus
	@ManyToOne(optional=true)
	@JoinColumn(name="Menus_id", referencedColumnName="id" , nullable=true)
	private Menus menus;

	//bi-directional many-to-one association to Menus
	@OneToMany(mappedBy="menus")
	
	private List<Menus> menuses;

	public Menus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getKey() {
		return this.menukey;
	}

	public void setKey(String menukey) {
		this.menukey = menukey;
	}

	public String getNumber() {
		return this.menunumber;
	}

	public void setNumber(String menunumber) {
		this.menunumber = menunumber;
	}

	public String getNumberunit() {
		return this.numberunit;
	}

	public void setNumberunit(String numberunit) {
		this.numberunit = numberunit;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Menus getMenus() {
		return this.menus;
	}

	public void setMenus(Menus menus) {
		this.menus = menus;
	}

	public List<Menus> getMenuses() {
		return this.menuses;
	}

	public void setMenuses(List<Menus> menuses) {
		this.menuses = menuses;
	}

	public Menus addMenus(Menus menus) {
		getMenuses().add(menus);
		menus.setMenus(this);

		return menus;
	}

	public Menus removeMenus(Menus menus) {
		getMenuses().remove(menus);
		menus.setMenus(null);

		return menus;
	}

	@Override
	public Map<String, Object> convertModelTOEDM() {
		 Map<String, Object> data = new HashMap<String, Object>();
try {
	
	data.put(ID,getId());
    data.put(TITLE, getTitle());
    data.put(INFO,  getInfo());
    data.put(NUMBER, getNumber());
    data.put(NUMBERUNIT, getNumberunit());
//    data.put(TARGETPAGE, get)
    data.put(TITLE, getTitle());
//    data.put(key, value)
    return data;
} catch (Exception e) {
return null;
}
		    
	}

	
	
	
	
	
	
	
	
	
	
	
	
}