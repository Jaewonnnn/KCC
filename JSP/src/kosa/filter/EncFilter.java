package kosa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter({"/board/*", "/session/*"}) //board 폴더에 들어가는 모든 요청에 대한 필터 (이 예시는 두가지 경로)
public class EncFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, 
						ServletResponse response, 
						FilterChain chain)
			throws IOException, ServletException {
		
		if(request.getCharacterEncoding() == null) { //인코딩이 없다면
			request.setCharacterEncoding("utf-8");
		}
		System.out.println("필터 적용 성공!");
		chain.doFilter(request, response); // 필터에서 이거 필수다. 까먹지마라

	}

}
