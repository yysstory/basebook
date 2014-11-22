package servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import servlets.dao.BoardDao;


@WebServlet("/delete")
public class boardDeleteServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		BoardDao boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
		
		
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		
		boardDao.delete(contentNo);
		
		HttpServletResponse orginResponse = (HttpServletResponse)response;
	    orginResponse.sendRedirect("/basebook");
		
	
	}

}
