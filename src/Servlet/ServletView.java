package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Jsoup.Main;

/**
 * Servlet implementation class ServletView
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ServletView" })
public class ServletView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String t="0";
		String e="0";
		t = request.getParameter("startTime");
		e = request.getParameter("endTime");
		if(t==null)t="0";
		if(e==null)e="0";
		long ti = Long.parseLong(t);
		long ei = Long.parseLong(e);
		ti*=1000;
		ei*=1000;
		
//		out.println(ti+"\n");
//		out.println(date+"\n");
//		out.println(formatter+"\n");
//		out.println(time+"\n");
		String st = Main.doMain(ti,ei);
		request.setAttribute("json", st);
		out.println(st);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String t="0";
		String e="0";
		t = request.getParameter("startTime");
		e = request.getParameter("endTime");
		if(t==null)t="0";
		if(e==null)e="0";
		long ti = Long.parseLong(t);
		long ei = Long.parseLong(e);
		ti*=1000;
		ei*=1000;
		
//		out.println(ti+"\n");
//		out.println(date+"\n");
//		out.println(formatter+"\n");
//		out.println(time+"\n");
		String st = Main.doMain(ti,ei);
		request.setAttribute("json", st);
		out.println(st);
	}

}
