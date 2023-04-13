package handler.kboard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import kboard.KboardService;
import kboard.KboardVo;

public class TitleHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");

		KboardService service = new KboardService();
		ArrayList<KboardVo> tlist = service.getByWriterAll(title);

		request.setAttribute("tlist", tlist);
		request.setAttribute("view", "/kboard/titlelist.jsp");

		return "/list.jsp";
	}

}
