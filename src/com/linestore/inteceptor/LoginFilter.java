package com.linestore.inteceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;  
	    HttpServletResponse res = (HttpServletResponse)response;  
	    String path = req.getContextPath(); 
	    String indexPath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+ "/home/login.jsp"; 
//	    System.out.println(req.getRequestURI());
	    if(req.getRequestURI().endsWith("login.jsp") 
	    		|| req.getRequestURI().endsWith("register.jsp") 
	    		|| req.getRequestURI().endsWith(".css") 
	    		|| req.getRequestURI().endsWith(".js")
	    		|| req.getRequestURI().endsWith(".jpg")
	    		|| req.getRequestURI().endsWith(".png")
	    		|| req.getRequestURI().endsWith(".action")
	    		|| req.getRequestURI().endsWith("Pay.jsp")
	    		|| req.getRequestURI().endsWith(".map")
	    		|| req.getRequestURI().endsWith(".woff2")
	    		|| req.getRequestURI().endsWith("upload.jsp")
	    		|| req.getRequestURI().endsWith("offlineStore.jsp"))
	    { 
//	    	System.out.println(req.getRequestURI());
	      chain.doFilter(request, response);  
	      return; 
	    } 
	      
	    Object loginuser = req.getSession().getAttribute("user");  
	    if(loginuser == null){ 
	      res.sendRedirect(indexPath);
	      System.out.println(req.getRequestURI());
	      System.out.println("***********");
	      return;  
	    } 
	    chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
