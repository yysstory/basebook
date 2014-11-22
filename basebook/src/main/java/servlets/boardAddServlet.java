package servlets;


import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import servlets.dao.BoardDao;
import servlets.domain.Board;


@WebServlet("/add")
public class boardAddServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;


	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("boardAddServlet서블릿 호출");
		
		Board board = new Board();
		
		board.setContentId(request.getParameter("id"));
		board.setContentPassword(request.getParameter("password"));
		board.setContentContent(request.getParameter("content"));
		board.setContentAvi("url");
		
		BoardDao boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
		
		boardDao.insert(board);
		
		HttpServletResponse orginResponse = (HttpServletResponse)response;
	    orginResponse.sendRedirect("/");
		
		
		
		
/*		
		
		
		  Product product = new Product();
		    product.setName(request.getParameter("name"));
		    product.setQuantity(Integer.parseInt(request.getParameter("qty")));
		    product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));
		    
		    //AppInitServlet.productDao.insert(product);
		    //ContextLoaderListener.productDao.insert(product);
		    
		    // ProductDao를 ServletContext 보관소에서 꺼내는 방식을 사용
		    // => 단점: 위의 방식보다 코드가 늘었다.
		    // => 장점: 특정 클래스에 종속되지 않는다. 유지보수에서 더 중요!
		    ProductDao productDao = (ProductDao)this.getServletContext()
		                                         .getAttribute("productDao");
		    try {
		      productDao.insert(product);
		      
		    } catch (Exception e) {
		       Forward로 다른 서블릿에게 제어권 위임하기
		       * => 제어권이 넘어가면 돌아오지 않는다.
		       
		      RequestDispatcher rd = 
		          request.getRequestDispatcher("/common/error");
		      request.setAttribute("error", e);
		      rd.forward(request, response);
		    }
		    
		    HttpServletResponse orginResponse = (HttpServletResponse)response;
		    orginResponse.sendRedirect("list");
		
		
		*/
		
		
		
		
	}

}
