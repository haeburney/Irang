package Chlog_comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class ChCommentDao {
private DBConnect dbconn;
	
	public ChCommentDao() {
		dbconn = DBConnect.getInstance();
	}
	
	// 1. 한 줄 추가
	
	public void insert(ChCommentVo vo) {
		String sql = "insert into Chlog_comment values(seq_Chcomment.nextval, ?, ?, ?, ?, sysdate)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getChildlogNum());
			pstmt.setString(2, vo.getTeacherId());
			pstmt.setString(3, vo.getChildId());
			pstmt.setString(4, vo.getContent());
			
			int num = pstmt.executeUpdate();
			System.out.println(num + "줄이 추가되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// 2-1. commentNum 으로 검색 
	public ChCommentVo selectByNum (int num) {
		ChCommentVo vo = null;
		String sql = "select * from Chlog_comment where comment_num = ?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ChCommentVo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
		
	}
	
	// 2-2. childlogNum 으로 검색 -- 아이 일지 밑에 해당 일지 코멘트 전체 출력
	public ArrayList<ChCommentVo> selectByLog(int num){
		ArrayList<ChCommentVo> list = new ArrayList<>();
		String sql = "select * form Chlog_comment where childlog_num = ?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ChCommentVo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// 3. 전체 검색 
	public ArrayList<ChCommentVo> selectAll(){
		ArrayList<ChCommentVo> list = new ArrayList<>();
		String sql = "select * form Chlog_comment";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ChCommentVo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	// 4. content 수정
	public void update (ChCommentVo vo) {
		String sql = "update Chlog_comment set content = ? where comment_num = ?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getChildlogNum());
			
			int num = pstmt.executeUpdate();
			System.out.println(num + "줄이 수정되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// 5. 삭제 
	public void delete (int num) {
		String sql = "delete from Chlog_comment where comment_num = ?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int number = pstmt.executeUpdate();
			System.out.println(number + "줄이 삭제되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
