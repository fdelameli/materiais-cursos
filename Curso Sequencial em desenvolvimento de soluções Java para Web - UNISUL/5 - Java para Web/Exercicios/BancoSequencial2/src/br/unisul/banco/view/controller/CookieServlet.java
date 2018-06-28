package br.unisul.banco.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void processRequest(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		boolean cookieEncontrado = false;
		String valueOfCookie = "0";

		Cookie[] cookieArray = request.getCookies();

		if(cookieArray != null){
			for(int i=0;i<cookieArray.length;i++){
//				Cookie cookie = cookieArray[i];
				if(cookieArray[i].getName().equals("idcookie")){
					Integer value = Integer.parseInt(cookieArray[i].getValue());
					cookieArray[i].setValue(String.valueOf(value+1));
					cookieArray[i].setMaxAge(365*24*60*60);
					valueOfCookie = cookieArray[i].getValue();
					cookieEncontrado = true;
					response.addCookie(cookieArray[i]);
				}

			}
		}

		if(!cookieEncontrado){
			Cookie cookie = new Cookie("idcookie","0");
			cookie.setMaxAge(365*24*60*60);
			response.addCookie(cookie);
		}
		
		System.out.println("Valor do cookie: " + valueOfCookie);
	}

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
	}

}
