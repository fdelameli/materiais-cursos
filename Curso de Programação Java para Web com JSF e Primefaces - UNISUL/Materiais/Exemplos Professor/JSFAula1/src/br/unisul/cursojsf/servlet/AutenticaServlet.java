package br.unisul.cursojsf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "autentica", urlPatterns = "/autenticar")
public class AutenticaServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if(req.getParameter("login").equals("unisul") &&
				req.getParameter("senha").equals("unisul")){
			req.getSession().setAttribute("login", req.getParameter("login"));
			resp.sendRedirect("restrito");
		}else{
			resp.sendRedirect("login.html");
		}
	
	
	}
	
}
