package child;

import java.sql.Date;

public class ChildVo {
	private String child_id;
	private String pwd;
	private String name;
	private String p_name;
	private Date birthday;
	private String allergy;
	private String phone;
	private int class_num;
	private String path;
	
	public ChildVo(String child_id, String pwd, String name, String p_name, Date birthday, String allergy, String phone,
			int class_num, String path) {
		super();
		this.child_id = child_id;
		this.pwd = pwd;
		this.name = name;
		this.p_name = p_name;
		this.birthday = birthday;
		this.allergy = allergy;
		this.phone = phone;
		this.class_num = class_num;
		this.path = path;
	}

	public ChildVo() {}
	
	public ChildVo(String child_id, String pwd, String name, String p_name, Date birthday, String allergy, String phone,
			int class_num) {
		super();
		this.child_id = child_id;
		this.pwd = pwd;
		this.name = name;
		this.p_name = p_name;
		this.birthday = birthday;
		this.allergy = allergy;
		this.phone = phone;
		this.class_num = class_num;
	}
	
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getChild_id() {
		return child_id;
	}

	public void setChild_id(String child_id) {
		this.child_id = child_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getClass_num() {
		return class_num;
	}

	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}

	@Override
	public String toString() {
		return "ChildVo [child_id=" + child_id + ", pwd=" + pwd + ", name=" + name + ", p_name=" + p_name
				+ ", birthday=" + birthday + ", allergy=" + allergy + ", phone=" + phone + ", class_num=" + class_num
				+ "]";
	}
	
	
	
	
	
	
}
