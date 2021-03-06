package com.myFirstServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "login servlet Testing",
        urlPatterns = {"/LoginServlet"}
)

public class LoginServlet extends HttpServlet {

    static String VALID_USERNAME = "^[A-Z]{1}[a-z]{2,}$";
    static String VALID_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=[^$@!#%*?&]*[$#@!%*?&][^$@!#%*?&]*$).{8,}$";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");

        boolean validName = (userName != null) && userName.matches(VALID_USERNAME);
        boolean pass = (userPassword != null) && userPassword.matches(VALID_PASSWORD);
        if (validName && pass) {
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Enter Valid UserName Or Password</font>");
            requestDispatcher.include(request, response);
        }
    }
}
