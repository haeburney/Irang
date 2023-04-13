package handler.kboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import kboard.KboardService;
import kboard.KboardVo;

public class DetailHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String view = "/list.jsp";

		int num = Integer.parseInt(request.getParameter("num"));
		KboardService service = new KboardService();
		KboardVo vo = service.getByNum(num);

		request.setAttribute("vo", vo);
		request.setAttribute("view", "/kboard/detail.jsp");

		return view;
	}

}
