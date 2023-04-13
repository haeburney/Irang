package child;

import java.util.ArrayList;

public class ChildService {
	private ChildDao dao;
	public final static String path="C:\\Users\\wnsgk\\Desktop\\web_workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\child\\";
	
	public ChildService() {
		dao = new ChildDao();
	}
	
	public void addChild(ChildVo vo) {
		dao.insert(vo);
	}
	
	public void editChild(ChildVo vo) {
		dao.update(vo);
	}
	
	public void delChild(String id) {
		dao.delete(id);
	}
	
	public ChildVo getById(String id) {
		return dao.selectById(id);
	}
	
	public ArrayList<ChildVo> getByAll(){
		return dao.selectAll();
	}
	
	public ArrayList<ChildVo> getByClass(int c){
		return dao.selectByClass(c);
	}

}
