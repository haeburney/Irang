package teacher;

public class TeacherVo {
	private String teacher_id;
	private String name;
	private String pwd;
	private String phone;
	private int class_num;

	public TeacherVo() {
	}

	public TeacherVo(String teacher_id, String name, String pwd, String phone, int class_num) {
		super();
		this.teacher_id = teacher_id;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.class_num = class_num;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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
		return "TeacherVo [teacher_id=" + teacher_id + ", name=" + name + ", pwd=" + pwd + ", phone=" + phone
				+ ", class_num=" + class_num + "]";
	}

}
