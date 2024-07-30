package kosa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String userName = request.getParameter("userName");
        String userID = request.getParameter("userID");
        String userPass = request.getParameter("userPass");
        String userEmail = request.getParameter("userEmail");
        String userPhoneNumber = request.getParameter("userPhoneNumber");
        String subscribe = request.getParameter("subscribe");
        
        request.setAttribute("userName", userName);
        request.setAttribute("userID", userID);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("userPhoneNumber", userPhoneNumber);
        request.setAttribute("subscribe", subscribe);
        
        // 페이지 이동
        RequestDispatcher re = request.getRequestDispatcher("/signupResult.jsp");
        re.forward(request, response);
    }


}
