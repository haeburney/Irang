package handler.kboard;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import kboard.KboardService;
import kboard.KboardVo;

public class AddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String view = "/list.jsp";
		
		if (request.getMethod().equals("GET")) {
			view= "/kboard/add.jsp";
		
		} else {
			
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Date e_date = Date.valueOf(request.getParameter("e_date"));
			
			KboardService service = new KboardService();
			service.addboard(new KboardVo (0,writer,title,null,content,e_date));
			
			view = "redirect:/kboard/list.do";
		}
			
		return view;
	}

}
