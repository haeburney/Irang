package child;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class ChildDao {
	private DBConnect dbconn;
	
	public ChildDao() {
		dbconn = DBConnect.getInstance();
	}
	
	public void insert(ChildVo vo) {
		Connection conn = dbconn.conn();
		String sql = "insert into child values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getChild_id());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getP_name());
			pstmt.setDate(5, vo.getBirthday());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getAllergy());
			pstmt.setInt(8, vo.getClass_num());
			pstmt.setString(9, vo.getPath());
			int num = pstmt.executeUpdate();
			System.out.println(num+"줄이 생성되었습니다.");
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
	
	public void update(ChildVo vo) {
		Connection conn = dbconn.conn();
		String sql = "update child set phone=?, allergy=?, class_num=?, path=? where child_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPhone());
			pstmt.setString(2, vo.getAllergy());
			pstmt.setInt(3, vo.getClass_num());
			pstmt.setString(4, vo.getPath());
			pstmt.setString(5, vo.getChild_id());
			int num = pstmt.executeUpdate();
			System.out.println(num+"줄이 수정되었습니다.");
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
	
	public void delete(String id) {
		Connection conn = dbconn.conn();
		String sql = "delete child where child_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int num = pstmt.executeUpdate();
			System.out.println(num+"줄이 삭제되었습니다.");
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

	
	public ArrayList<ChildVo> selectByClass(int c){
		ArrayList<ChildVo> list = new ArrayList<ChildVo>();
		Connection conn = dbconn.conn();
		String sql = "select * from child where class_num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ChildVo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9)));
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
	
	public ArrayList<ChildVo> selectAll(){
		ArrayList<ChildVo> list = new ArrayList<ChildVo>();
		Connection conn = dbconn.conn();
		String sql = "select * from child";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ChildVo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9)));
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
	
	public ChildVo selectById(String id){
		ChildVo vo = null;
		Connection conn = dbconn.conn();
		String sql = "select * from child where child_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new ChildVo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9));
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
