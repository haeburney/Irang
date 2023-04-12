package teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;
import kclass.ClassVo;

public class TeacherDao {
	public DBConnect dbconn;
	
		public void insert (TeacherVo vo) {
			dbconn = DBConnect.getInstance();
			String sql = "insert into teacher values (t_?,?,?,?,?)";
			Connection conn = dbconn.conn();
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getTeacher_id());
				pstmt.setString(2, vo.getName());
				pstmt.setString(3, vo.getPwd());
				pstmt.setString(4, vo.getPhone());
				pstmt.setInt(4, vo.getClass_num());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	
	public void update (TeacherVo vo) {
		dbconn = DBConnect.getInstance();
		String sql = "update teacher set name =?,pwd =?,phone =?, class_num =? where teacher_id =?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getPwd());
			pstmt.setString(3,vo.getPhone());
			pstmt.setInt(4, vo.getClass_num());
			pstmt.setString(5,vo.getTeacher_id());
			
			pstmt.executeUpdate();
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
	
	public void delete (String id) {
		dbconn = DBConnect.getInstance();
		String sql = "delete teacher where teacher_id=?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
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
	
	public TeacherVo selectById(String id){
		TeacherVo vo = null;
		dbconn = DBConnect.getInstance();
		String sql = "select * from teacher where teacher_id =?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new TeacherVo(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4) ,rs.getInt(5));
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
	
	
}
