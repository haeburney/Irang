package childLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class ChildLogDao {
	private DBConnect dbconn;

	public ChildLogDao() {
		dbconn = DBConnect.getInstance();
	}

	// 1. 날짜도 직접 추가
	public void insertAll(ChildLogVo vo) {
		Connection conn = dbconn.conn();
		String sql = "insert into childlog values (c_log_seq.nextval,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTeacher_id());
			pstmt.setString(2, vo.getChild_id());
			pstmt.setDate(3, vo.getC_date());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getC_check());

			int check = pstmt.executeUpdate();
			System.out.println(check + "줄 추가됨");

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
	
	// 2. 날짜 오늘로 insert
	public void insertToday(ChildLogVo vo) {
		Connection conn = dbconn.conn();
		String sql = "insert into childlog values (c_log_seq.nextval,?,?,sysdate,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTeacher_id());
			pstmt.setString(2, vo.getChild_id());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getC_check());

			int check = pstmt.executeUpdate();
			System.out.println(check + "줄 추가됨");

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

	// 3. 수정 : 내용만
	public void update(ChildLogVo vo) {
		Connection conn = dbconn.conn();

		// 업데이트 뭐뭐하지?
		String sql = "update childlog set content=? where childlog_num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(5, vo.getContent());
			pstmt.setInt(1, vo.getChildlog_num());

			int check = pstmt.executeUpdate();
			System.out.println(check + "줄 수정됨");

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

	// 4. 전체 : 선생님 로그인 했을 때 모든거 다 보이게 
	public ArrayList<ChildLogVo> seleteAll() {
		Connection conn = dbconn.conn();
		ArrayList<ChildLogVo> list = new ArrayList<>();
		String sql = "select * from childlog";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ChildLogVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getString(6)));
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
	
	// 5. 선생님 로그인 했을 때 체크 안 한 것만
	public ArrayList<ChildLogVo> seleteCheck() {
		Connection conn = dbconn.conn();
		ArrayList<ChildLogVo> list = new ArrayList<>();
		String sql = "select * from childlog where c_check=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "1");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ChildLogVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getString(6)));
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


	// 6. 삭제
	public void delete(int num) {
		Connection conn = dbconn.conn();
		String sql = "delete from childlog where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int check = pstmt.executeUpdate();
			System.out.println(check + "줄 삭제됨");
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
	
	
	// 7. child_id로 검색 (보호자 리스트)
	public ArrayList<ChildLogVo> selectId(String id) {
		Connection conn = dbconn.conn();
		ArrayList<ChildLogVo> list = new ArrayList<>();
		String sql = "select * from childlog where child_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ChildLogVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getString(6)));
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
	
	
	// 8. childlog_num으로 검색
	public ChildLogVo selectNum(int num) {
		Connection conn = dbconn.conn();
		String sql = "select * from childlog where childlog_num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				ChildLogVo vo = new ChildLogVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6));
				return vo;
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
		return null;
	}
	
	
	// c_date 날짜로 검색
}
