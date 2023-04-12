package teacher;

import java.util.ArrayList;

public class TeacherService {
TeacherDao dao = new TeacherDao();
	
	public void addVo(TeacherVo vo) {
		dao.insert(vo);
	}
	
	public TeacherVo getVo(String id) {
		return dao.selectById(id);
		
	}
	
	public void editVo(TeacherVo vo) {
		dao.update(vo);
	}
	
	public void delVo(String id) {
		dao.delete(id);
	}
}
