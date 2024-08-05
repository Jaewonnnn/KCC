package kosa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/membership")
public class membership extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public membership() {
        super();
        
    }


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		doPost(request, response);
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		System.out.println("호출");
		
		String userName = request.getParameter("userName");
		String userID = request.getParameter("userID");
		String userPass = request.getParameter("userPass");
		String userPassCheck = request.getParameter("userPassCheck");
		String emailPrefix = request.getParameter("emailPrefix");
		String emailDomain = request.getParameter("emailDomain");
		String contact = request.getParameter("contact");
		String subscribe = request.getParameter("subscribe");
//		String[] membership = request.getParameterValues("language");
		
		String email = emailPrefix + "@" + emailDomain;
		
		request.setAttribute("userName", userName);
		request.setAttribute("userID", userID);
		request.setAttribute("userPass", userPass);
		request.setAttribute("userPassCheck", userPassCheck);
		request.setAttribute("email", email);
		request.setAttribute("contact", contact);
		request.setAttribute("subscribe", subscribe);
//		request.setAttribute("membership", membership);
		
		RequestDispatcher re = request.getRequestDispatcher("/loginResult.jsp");
		re.forward(request, response); //forward를 통해 전달
	}

}
