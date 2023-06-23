package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CookiesGetAndDeleteServlet")
public class CookiesGetAndDeleteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // cookies
            Cookie[] cookies = request.getCookies(); // 클라리언트에서 보낸 쿠키들을 리스트 안에 담는다.
            String content = "<div>CookiesGetAndDeleteServlet</div>";  // cookie는 HashMap 형태로 뽑아낸다.
            for(Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                if(name.equals("secondName")) {  // 쿠키삭제
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                } else { // 출력
                    content = content + "<div>"+name+", "+value+"</div>";
                }
            }
            // display
            PrintWriter printWriter = response.getWriter();
            printWriter.println(content);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
