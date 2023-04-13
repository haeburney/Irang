package handler.kboard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import kboard.KboardService;
import kboard.KboardVo;

public class WriterHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String writer = request.getParameter("wrtier");
		
		KboardService service = new KboardService(); 
		ArrayList<KboardVo> wlist = service.getByWriterAll(writer);
		
		request.setAttribute("wlist", wlist); 
		request.setAttribute("view" , "/kboard/writerlist.jsp");
		
		return "/list.jsp";
		
		
	}

}
