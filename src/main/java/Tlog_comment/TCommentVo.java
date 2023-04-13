package Tlog_comment;

import java.sql.Date;

public class TCommentVo {
	private int commentNum;
	private int teacherlogNum;
	private String teacherId;
	private String childId;
	private String content;
	private Date comDate;
	
	public TCommentVo() {}
	
	public TCommentVo(int commentNum, int teacherlogNum, String teacherId, String childId, String content,
			Date comDate) {
		super();
		this.commentNum = commentNum;
		this.teacherlogNum = teacherlogNum;
		this.teacherId = teacherId;
		this.childId = childId;
		this.content = content;
		this.comDate = comDate;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getTeacherlogNum() {
		return teacherlogNum;
	}

	public void setTeacherlogNum(int teacherlogNum) {
		this.teacherlogNum = teacherlogNum;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getChildId() {
		return childId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getComDate() {
		return comDate;
	}

	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	@Override
	public String toString() {
		return "CommentVo [commentNum=" + commentNum + ", teacherlogNum=" + teacherlogNum + ", teacherId=" + teacherId
				+ ", childId=" + childId + ", content=" + content + ", comDate=" + comDate + "]";
	}
	
	

}
