package com.ecoman.springboot;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter {
	private ServletContext sc = null;

	// Filter implementation
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		sc = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//进行安全管控的动作
		sc.log("请求："+((HttpServletRequest)request).getRequestURL());
		
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
