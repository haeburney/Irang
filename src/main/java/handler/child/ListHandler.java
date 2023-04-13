package handler.child;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import child.ChildService;
import child.ChildVo;
import handler.Handler;

public class ListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String view="";
		if(request.getMethod().equals("GET")) {
			ChildService service = new ChildService();
			ArrayList<ChildVo> list = service.getByClass(0);
			request.setAttribute("list", list);
			view="/child/list.jsp";
		} else {
			
		}
		return view;
	}
	
}


