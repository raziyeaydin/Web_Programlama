package com.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionBilgilerini_yaz")
public class sessionBilgilerini_yaz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer accessCount = (Integer) session.getAttribute("accessCount");
		if(accessCount == null ){
			accessCount = 0;
		}
		else{
			accessCount++ ;
		}
		session.setAttribute("accessCount", accessCount);
		
		String id = session.getId();
		Date creationTime = new Date(session.getCreationTime());
		Date lastAccessedTime = new Date(session.getLastAccessedTime());
		Integer maxInactiveInterval = session.getMaxInactiveInterval();
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<htlm><body><table>");
		pw.println("<tr><td>Session ID </td><td>"+id+"</td>");
		pw.println("<tr><td>Creation Time </td><td>"+creationTime+"</td>");
		pw.println("<tr><td>lastAccessTime </td><td>"+lastAccessedTime+"</td>");
		pw.println("<tr><td>maxInactiveInterval </td><td>"+maxInactiveInterval+"</td>");
		pw.println("<tr><td>Access Count </td><td>"+accessCount+"</td>");
		pw.println("</table></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
