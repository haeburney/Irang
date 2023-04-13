package kboard;

import java.sql.Date;
import java.util.ArrayList;


public class KboardService {

	private KboardDao dao;

	public KboardService() {
		dao = new KboardDao();
	}

	// 글작성
	public void addboard(KboardVo vo) {
		dao.insert(vo);
	}
	
	//글 번호로 검색 
	public KboardVo getByNum(int num) {
		return dao.select(num);
	}

	// 글 수정
	public void editboard(KboardVo vo) {
		dao.update(vo);
	}
	

	// 글 삭제
	public void delBoard(int num) {
		dao.delete(num);
	}
	
	// 작성자로 검색
		public ArrayList<KboardVo> getByWriterAll(String teacher_Id) {
			return dao.getByWriter(teacher_Id);

		}

		// 제목으로 검색
		public ArrayList<KboardVo> getByTitle(String title) {
			return dao.getByTitle(title);		
		}
		
		//이벤트 날짜로 검색 
		public ArrayList<KboardVo> getByDate (Date e_date) {
		 return dao.selectevent(e_date);
		}
		
		// 전체 목록 
		public ArrayList<KboardVo> getAll() {
			return dao.selectAll();
		}
		

		
}
