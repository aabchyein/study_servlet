package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/cookies/CreateServlet")
public class CookiesCreateServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {

        //cookie 
        // 쿠키는 instance하면서 parameter 만드는 경우 중에 하나 //여긴 임의적으로 만든 경우
        Cookie cookie_first = new Cookie("firstName", "Angela!");
        Cookie cookie_second = new Cookie("secondName", "Lab!");

        //클라이언트에 보낼 것 넣기 
        response.addCookie(cookie_first);
        response.addCookie(cookie_second);

        // display(HTML 관련된 부분이라 쿠키와는 관련없음)
        PrintWriter printWriter = response.getWriter();
        String content = "<div>CreateCookieServlets</div>";
        printWriter.println(content);
        printWriter.close();

        
       } catch (Exception e) {
        System.out.println(e.getMessage());
       }
    }
}
