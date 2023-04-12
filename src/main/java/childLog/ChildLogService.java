package childLog;

import java.util.ArrayList;

public class ChildLogService {
	private ChildLogDao dao;
	
	public ChildLogService() {
		dao = new ChildLogDao();
	}
	
	// 1. 보호자 일지 추가 (날짜 보호자가 선택)
	public void clInsert(ChildLogVo vo) {
		dao.insertAll(vo);
	}
	
	// 2. 보호자 일지 추가 (오늘 날짜)
	public void clInsertToday(ChildLogVo vo) {
		dao.insertToday(vo);
	}
	
	// 3. content 수정
	public void clUpdate(ChildLogVo vo) {
		dao.update(vo);
	}
	
	// 4. 전체 보기
	public ArrayList<ChildLogVo> clAll() {
		return dao.seleteAll();
	}
	
	// 5. 선생님 : 체크 안 한 것만 
	public ArrayList<ChildLogVo> clCheck() {
		return dao.seleteCheck();
	}
	
	// 6. 삭제
	public void clDelete(int num) {
		dao.delete(num);
	}
	
	// 7. child_id로 검색
	public ArrayList<ChildLogVo> clChildSelectId(String id) {
		return dao.selectId(id);
	}
	
	// 8. child_num으로 검색
	public ChildLogVo clChildSelectNum(int num) {
		return dao.selectNum(num);
	}
	
}
