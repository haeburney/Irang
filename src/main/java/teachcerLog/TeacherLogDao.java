package teachcerLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class TeacherLogDao {
	private DBConnect dbconn;

	public TeacherLogDao() {
		dbconn = DBConnect.getInstance();
	}

	// 날짜도 선생님이 추가
	public void insertAll(TeacherLogVo vo) {
		Connection conn = dbconn.conn();
		String sql = "insert into teacherlog values (t_log_seq.nextval,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTeacher_id());
			pstmt.setString(2, vo.getChild_id());
			pstmt.setDate(3, vo.getT_date());
			pstmt.setString(4, vo.getActivity());
			pstmt.setString(5, vo.getHealth());
			pstmt.setString(6, vo.getImg1());
			pstmt.setString(7, vo.getImg2());
			pstmt.setString(8, vo.getImg3());

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
	
	// 추가 오늘 날짜로 sysdate 
	public void insertToday(TeacherLogVo vo) {
		Connection conn = dbconn.conn();
		String sql = "insert into teacherlog values (t_log_seq.nextval,?,?,sysdate,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTeacher_id());
			pstmt.setString(2, vo.getChild_id());
			pstmt.setString(3, vo.getActivity());
			pstmt.setString(4, vo.getHealth());
			pstmt.setString(5, vo.getImg1());
			pstmt.setString(6, vo.getImg2());
			pstmt.setString(7, vo.getImg3());

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

	// 활동 건강 둘 다 수정
	public void updateAll(TeacherLogVo vo) {
		Connection conn = dbconn.conn();
		String sql = "update teacherlog set activity=?, health=? where teacherlog_num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getActivity());
			pstmt.setString(2, vo.getHealth());

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

	// 활동만 수정
	public void updateActivity(TeacherLogVo vo) {
		Connection conn = dbconn.conn();
		String sql = "update teacherlog set activity=? where teacherlog_num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getActivity());

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

	// 건강만 수정
	public void updateHealth(TeacherLogVo vo) {
		Connection conn = dbconn.conn();
		String sql = "update teacherlog set  health=? where teacherlog_num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getHealth());

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

	// 전체
	public ArrayList<TeacherLogVo> seleteAll() {
		Connection conn = dbconn.conn();
		ArrayList<TeacherLogVo> list = new ArrayList<>();
		String sql = "select * from teacherlog";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new TeacherLogVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9)));
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

	// 삭제
	public void delete(int num) {
		Connection conn = dbconn.conn();
		String sql = "delete from teacherlog where num=?";
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
	
	// child_id로 검색 → 보호자 입장에서 보이는 리스트 
	public ArrayList<TeacherLogVo> selectChildId(String id) {
		Connection conn = dbconn.conn();
		ArrayList<TeacherLogVo> list = new ArrayList<>();
		String sql = "select * from teacherlog where child_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new TeacherLogVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9)));
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

	
	// teacher_id로 검색 → 선생님이 일지 작성으로 들어가면 보이는 리스트
	public ArrayList<TeacherLogVo> selectTeacherId(String id) {
		Connection conn = dbconn.conn();
		ArrayList<TeacherLogVo> list = new ArrayList<>();
		String sql = "select * from teacherlog where teacher_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new TeacherLogVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9)));
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
}
