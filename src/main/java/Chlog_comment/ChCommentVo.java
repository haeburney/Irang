package Chlog_comment;

import java.sql.Date;

public class ChCommentVo {
	private int commentNum;
	private int childlogNum;
	private String teacherId;
	private String childId;
	private String content;
	private Date comDate;
	
	public ChCommentVo() {}

	public ChCommentVo(int commentNum, int childlogNum, String teacherId, String childId, String content, Date comDate) {
		super();
		this.commentNum = commentNum;
		this.childlogNum = childlogNum;
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

	public int getChildlogNum() {
		return childlogNum;
	}

	public void setChildlogNum(int childlogNum) {
		this.childlogNum = childlogNum;
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
		return "CommentVo [commentNum=" + commentNum + ", childlogNum=" + childlogNum + ", teacherId=" + teacherId
				+ ", childId=" + childId + ", content=" + content + ", comDate=" + comDate + "]";
	}
	
	
	
	

}
