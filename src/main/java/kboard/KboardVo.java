package kboard;

import java.sql.Date;

public class KboardVo {
	
	private int board_num;
	private String teacher_Id;
	private String title;
	private Date w_date; 
	private String content;
	private Date e_date;
	
	
	
	public KboardVo(int board_num, String teacher_Id, String title, Date w_date, String content, Date e_date) {
		super();
		this.board_num = board_num;
		this.teacher_Id = teacher_Id;
		this.title = title;
		this.w_date = w_date;
		this.content = content;
		this.e_date = e_date;
	}



	public int getBoard_num() {
		return board_num;
	}



	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}



	public String getTeacher_Id() {
		return teacher_Id;
	}



	public void setTeacher_Id(String teacher_Id) {
		this.teacher_Id = teacher_Id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Date getW_date() {
		return w_date;
	}



	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Date getE_date() {
		return e_date;
	}



	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}



	@Override
	public String toString() {
		return "KboardVo [board_num=" + board_num + ", teacher_Id=" + teacher_Id + ", title=" + title + ", w_date="
				+ w_date + ", content=" + content + ", e_date=" + e_date + "]";
	} 
	
	
	
	
	
	
	



	
	

}
