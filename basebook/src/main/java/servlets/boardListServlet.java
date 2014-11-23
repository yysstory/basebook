package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import servlets.dao.BoardDao;
import servlets.domain.Board;

@WebServlet("/list")
public class boardListServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		System.out.println("boardListServlet 호출");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		BoardDao boardDao = (BoardDao) this.getServletContext().getAttribute(
				"boardDao");
		List<Board> boardList = boardDao.selectList();

/*		for (Board board : boardList) {
			out.print(board.getContentNo() + " ");
			out.print(board.getContentId() + " ");

			out.print("<pre>" + board.getContentContent() + "</pre>");

			out.print(board.getContentPassword() + " ");
			out.print(board.getContentAvi() + " ");
			out.print("</br>");
		}*/

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("<link href='css/bootstrap.min.css' rel='stylesheet' media='screen'>");
		out.println("<link rel='stylesheet' type='text/css' href='css/common.css'>");

		out.println("</head>");
		out.println("<body>");

		out.println("	<div id=add_content>");

		
		out.println("	<form  role='form' action='add' role='form' method='post'>");
		out.println("		<textarea name=content class=form-control rows='10' cols='35' placeholder='내용을 추가해주세요!'></textarea>");
		out.println("		<input name=url class=form-control type='text'  placeholder='이미지URL or 유투브 URL'>");
		out.println("		<input name=id class=form-control type='text'  placeholder='아이디'>");
		out.println("		<input name=password class=form-control type='password'  placeholder='비밀번호'>");
		out.println("		<button type='submit' class='btn btn-large btn-block'>Submit</button>");

		out.println("</form>");
		out.println("</div>");

		out.println("<div class=container>");
		
		out.println("<section>");
		
		for (Board board : boardList) {
		


		out.println("<table>");
		out.println("<tr><th>");
		out.println("  No."+board.getContentNo()+"  "+board.getContentId()+" 님이 작성 "); //아이디
		out.println("<th></tr>");

		out.println("<tr><td>");//동영상  url
		
		if(board.getContentAvi()!=""){
		String []urlSplit = board.getContentAvi().split("\\.");
		
			if(urlSplit[urlSplit.length-1].equals("png")||urlSplit[urlSplit.length-1].equals("jpg")||urlSplit[urlSplit.length-1].equals("jpeg")){
				out.println("<center><img src='"+board.getContentAvi() +"' width='450' ></center>");
		
		//만약 무언가 주소가 있다면
			}else{
				out.println("<center><iframe width='450' height='300' src='//www.youtube.com/embed/"+board.getContentAvi().split("/")[board.getContentAvi().split("/").length-1]+"' frameborder='0' allowfullscreen></iframe></center>");
			}
		}
		//만약 url이 그림파일이라면 
		
		  
		out.println("</td></tr>");

		out.println("<tr><td>");//내용

		out.print("<pre>" + board.getContentContent() + "</pre>");

		out.println("</td></tr>");

		out.println("<tr id='iconCombine'><td>");
		out.println("<span class='glyphicon glyphicon-thumbs-up' aria-hidden='true'>0</span>");

		out.println("<span class='glyphicon glyphicon-thumbs-down' aria-hidden='true'>1</span>");

		out.println("<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>");

		out.println("<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>");

		out.println("<span class='glyphicon glyphicon-user' aria-hidden='true'>0</span>");

		out.println("</td></tr>");
		
		out.println("</table>");
		
		out.println("</br>");
		out.println("</br>");

		}

		out.println("</section >");
		
		out.println("	<header>aaaaaaaaaa</header>");
		out.println("	<footer>ddddddd 좋아요순 정렬 싫어요순 정렬 </footer>");

		out.println("	<script src='js/jquery-1.11.1.js'></script>");
		out.println("    <script src='js/bootstrap.min.js'></script>");
		out.println("    <script src='js/respond.js'></script>");

		out.println("</body>");
		out.println("</html>");

	}

}
