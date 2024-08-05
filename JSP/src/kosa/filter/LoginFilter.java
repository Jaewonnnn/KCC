package kosa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/session/main.jsp", "/session/logout.jsp"})
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// ServletRequest를 HttpServletRequest로 캐스팅 -> 이거 필수다
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();

		String name = (String) session.getAttribute("name");

		if (session == null || session.getAttribute("name") == null) {
		httpResponse.sendRedirect(httpRequest.getContextPath() +
		"/session/loginform.jsp"); return; }
		

		System.out.println("처리했나?");
		chain.doFilter(httpRequest, httpResponse);

	}

}
