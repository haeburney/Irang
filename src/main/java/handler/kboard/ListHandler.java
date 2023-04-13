package handler.kboard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import kboard.KboardService;
import kboard.KboardVo;

public class ListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		KboardService service = new KboardService(); 
		ArrayList<KboardVo> list = service.getAll();
		request.setAttribute("list", list); 
		request.setAttribute("view" , "/kboard/list.jsp");
		
		return "/list.jsp";
	}

}
