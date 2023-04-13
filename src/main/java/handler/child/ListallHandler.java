package handler.child;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import child.ChildService;
import child.ChildVo;
import handler.Handler;

public class ListallHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String view="";
		if(request.getMethod().equals("GET")) {
			ChildService service = new ChildService();
			ArrayList<ChildVo> list = service.getByAll();
			request.setAttribute("list", list);
			view="/child/listall.jsp";
		} else {
			
		}
		return view;
	}

}
