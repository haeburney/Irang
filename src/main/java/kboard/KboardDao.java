package kboard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class KboardDao {
	
	private DBConnect dbconn;
	
	public KboardDao() {
		dbconn = DBConnect.getInstance();
	}
	
	
	//게시판 추가하기 
	public void insert(KboardVo vo) {
		Connection conn = dbconn.conn();

		String sql = "insert into k_board values (seq_kboradnum.nextval, ?, ? ,sysdate, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTeacher_Id());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setDate(4, vo.getE_date()); 

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

	
	// 글번호로 검색하여 title, content 이벤트 날짜 수정
	public void update(KboardVo vo) {
		Connection conn = dbconn.conn();

		String sql = "update k_board set title = ?, content = ?  e_date =? where board_num = ?";

		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setDate(3, vo.getE_date());
			pstmt.setInt(3, vo.getBoard_num());

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

	
	// 글번호로 검색하여 글 삭제
	public void delete(int num) {
		
		Connection conn = dbconn.conn();
		String sql = "delete k_board where board_num = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			 pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 전체검색
	public ArrayList<KboardVo> selectAll() {
		
		ArrayList<KboardVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();
		String sql = "select * from k_board order by num desc";

		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new KboardVo (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDate(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 작성자로 검색(작성자가 작성한 글 모두 검색)
	public ArrayList<KboardVo> getByWriter(String teacher_Id) {
			
			ArrayList<KboardVo> list =  new ArrayList<>();
			
			Connection conn = dbconn.conn();
			String sql = "select * from  k_board where writer like ?";

			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, "%" + teacher_Id + "%");
				ResultSet rs = pstmt.executeQuery(); 

				while (rs.next()) {
					list.add(new KboardVo (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDate(6)));
				}
	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;
		}

	// 글 번호로 검색
	public KboardVo select(int num) {
		
		Connection conn = dbconn.conn();
		String sql = "select * from  k_board where num = ?";
		KboardVo vo = null;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int num1 = rs.getInt(1);
				String teacher=rs.getString(2);
				String title=rs.getString(3);
				Date w_date = rs.getDate(4);
				String content = rs.getString(5);
				Date e_date = rs.getDate(6);

				vo = new KboardVo(num1, teacher, title, w_date, content, e_date);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	// 제목으로 검색(검색 단어가 제목에 포함된 모든 글)
	public ArrayList<KboardVo> getByTitle(String title) {
		
		ArrayList<KboardVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();
		String sql = "select * from k_board where title like  ? ";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + title + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new KboardVo (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDate(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//날짜로 검색하느 메서드 추가 
	public ArrayList<KboardVo> selectevent (Date e_date) {
		
		ArrayList<KboardVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();
		String sql = "select * from k_board where e_date = ? order by num asc";

		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1,e_date);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new KboardVo (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDate(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	

}