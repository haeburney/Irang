package handler.child;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import child.ChildService;
import child.ChildVo;
import handler.Handler;

public class IdcheckHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		ChildService service = new ChildService();
		ChildVo vo = service.getById(id);
		boolean flag = (vo==null);
		JSONObject obj = new JSONObject();
		obj.put("flag", flag);
		String txt = obj.toJSONString();
		return "responsebody/"+ txt;
	}

}
