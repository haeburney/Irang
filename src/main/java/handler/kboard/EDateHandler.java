package handler.kboard;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import kboard.KboardService;
import kboard.KboardVo;

public class EDateHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Date e_date = Date.valueOf(request.getParameter("e_date"));
		
		KboardService service = new KboardService(); 
		ArrayList<KboardVo> edate = service.getByDate(e_date);
		
		request.setAttribute("edate", edate);
		request.setAttribute("view", "/kboard/edatelist.jsp");
		
		return "/list.jsp";
	}

}
