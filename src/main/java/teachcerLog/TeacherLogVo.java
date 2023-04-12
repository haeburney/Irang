package teachcerLog;

import java.sql.Date;

public class TeacherLogVo {
	private int teacherlog_num;
	private String teacher_id;
	private String child_id;
	private Date t_date;
	private String activity;
	private String health;
	private String img1;
	private String img2;
	private String img3;

	public TeacherLogVo() {

	}

	public TeacherLogVo(int teacherlog_num, String teacher_id, String child_id, Date t_date, String activity,
			String health, String img1, String img2, String img3) {
		super();
		this.teacherlog_num = teacherlog_num;
		this.teacher_id = teacher_id;
		this.child_id = child_id;
		this.t_date = t_date;
		this.activity = activity;
		this.health = health;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
	}

	public int getTeacherlog_num() {
		return teacherlog_num;
	}

	public void setTeacherlog_num(int teacherlog_num) {
		this.teacherlog_num = teacherlog_num;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getChild_id() {
		return child_id;
	}

	public void setChild_id(String child_id) {
		this.child_id = child_id;
	}

	public Date getT_date() {
		return t_date;
	}

	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	@Override
	public String toString() {
		return "TeacherLogVo [teacherlog_num=" + teacherlog_num + ", teacher_id=" + teacher_id + ", child_id="
				+ child_id + ", t_date=" + t_date + ", activity=" + activity + ", health=" + health + ", img1=" + img1
				+ ", img2=" + img2 + ", img3=" + img3 + "]";
	}

}
