package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/sessionDeleteServlet")
public class SessionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // expired session
            HttpSession httpSession = request.getSession();
            httpSession.invalidate(); // Sever side , 서버에서 삭제(클라이언트에는 계속 남아있음), JSESSIONID가 존재는 하지만 DATE가 invalid됨

            // delete cookies
            Cookie[] cookies = request.getCookies();
            String content = "<div>CookiesGetAndDeleteServlet</div>";
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                if (name.equals("JSESSIONID")) { // Client side , 쿠키 삭제
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                } else {   // 출력
                    content = content + "<div>" + name + ", " + value + "</div>";
                }
            }
            PrintWriter printWriter = response.getWriter();
            String contents = "<div>Logout !</div>";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
