package handler.child;

import java.io.File;
import java.io.IOException;
import java.sql.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import child.ChildService;
import child.ChildVo;
import handler.Handler;

public class JoinHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "";
		if(request.getMethod().equals("GET")) {
			view = "/child/join.jsp";
		} else {
			int size = 100 * 1024 * 1024; // 100M
	        MultipartRequest multipart;
			try {
				multipart = new MultipartRequest(request, ChildService.path, size, "euc-kr", new DefaultFileRenamePolicy());
				File f1 = multipart.getFile("path");
		        
		        
		        String fname1 = "nopic.png";
		        
		        
		        if(f1 != null) {
		        	fname1 = f1.getName();
		        }
				String id = multipart.getParameter("id");
				String pwd = multipart.getParameter("pwd");
				String name = multipart.getParameter("name");
				String p_name = multipart.getParameter("p_name");
				Date birthday = Date.valueOf(multipart.getParameter("birthday"));
				String phone = multipart.getParameter("phone");
				int class2 = Integer.parseInt(multipart.getParameter("classNum"));
				
				ChildService service = new ChildService();
				service.addChild(new ChildVo(id,pwd,name,p_name,birthday,null,phone,class2,fname1));
				
				view = "redirect:/child/listall.do";
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        
	        
		}
		return view;
	}

}
