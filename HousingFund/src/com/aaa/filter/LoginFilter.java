package com.aaa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.entity.Users;

public class LoginFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		        Users user=  (Users) request.getSession().getAttribute("user");
		          if(user==null){//�ѵ�¼״̬
		              System.out.print("�ѵ�¼");
		          }else{//δ��¼״̬
		        	  System.out.print("δ��¼");
		        	  response.sendRedirect("/login.jsp");
		          }
		          chain.doFilter(request, response);//����ִ��
	}

	@Override
	public void destroy() {
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
