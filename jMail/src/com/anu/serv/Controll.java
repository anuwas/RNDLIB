package com.anu.serv;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controll() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = this.getServletContext().getRealPath("/templates/template1.html");
		TemplateAction ta = new TemplateAction();
		response.getWriter().append("HtmlOutput: ").append(ta.readTemplate(path));
		response.getWriter().append("<br>");
		response.getWriter().append("HtmlOutput: ").append(URLEncoder.encode(ta.readTemplate(path), "UTF-8"));
	}

}
