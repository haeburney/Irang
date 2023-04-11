package childLog;

import java.sql.Date;

public class ChildLogVo {
	private int childlog_num;
	private String teacher_id;
	private String child_id;
	private Date c_date;
	private String content;
	private String c_check;
	
	public ChildLogVo() {
		
	}

	public ChildLogVo(int childlog_num, String teacher_id, String child_id, Date c_date, String content,
			String c_check) {
		super();
		this.childlog_num = childlog_num;
		this.teacher_id = teacher_id;
		this.child_id = child_id;
		this.c_date = c_date;
		this.content = content;
		this.c_check = c_check;
	}

	public int getChildlog_num() {
		return childlog_num;
	}

	public void setChildlog_num(int childlog_num) {
		this.childlog_num = childlog_num;
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

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getC_check() {
		return c_check;
	}

	public void setC_check(String c_check) {
		this.c_check = c_check;
	}

	@Override
	public String toString() {
		return "ChildLogVo [childlog_num=" + childlog_num + ", teacher_id=" + teacher_id + ", child_id=" + child_id
				+ ", c_date=" + c_date + ", content=" + content + ", c_check=" + c_check + "]";
	}

	
}
