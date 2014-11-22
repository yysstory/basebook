

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/add")
public class boardAddServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;


	
	public void service(ServletRequest request, ServletResponse response)  {

		System.out.println("add");
		
	}

}
