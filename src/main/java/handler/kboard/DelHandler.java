package handler.kboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import kboard.KboardService;

public class DelHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int num = Integer.parseInt(request.getParameter("num"));
		KboardService service = new KboardService(); 
		service.delBoard(num);
		
		
		return "kboard/list.do";
	}

}
