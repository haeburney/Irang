package handler.kboard;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import kboard.KboardService;
import kboard.KboardVo;

public class EditHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String view = "/list.jsp";
		
	if(	request.getMethod().equals("GET")) {
		
			int num= Integer.parseInt(request.getParameter("num"));
		KboardService service = new KboardService(); 
		KboardVo vo = service.getByNum(num);
		request.setAttribute("vo", vo);
		request.setAttribute("view", "/kboard/edit.jsp");
	} else {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date e_date = Date.valueOf(request.getParameter("e_date"));
		
		KboardService service = new KboardService(); 
		service.editboard(new KboardVo(num,null,title,null,content,e_date));
		view = "redirect:/kboard/detail.do?num=" + num;
		
	}
		
		return null;
	}

	}
