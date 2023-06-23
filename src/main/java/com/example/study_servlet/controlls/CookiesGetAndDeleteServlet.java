package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies/GetAndDeleteServlet")
public class CookiesGetAndDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            // cookies 클라이언트로 들어올때는 리스트어레이 상태로 올라와고 키를 알 수 없다.
            // 안에 든 cookie는 해쉬맵
            // 루핑 돌아서 뭐가 들어있는지 확인하고 삭제한다.
            String content = "<div>CookiesGetAndDeleteServlet</div>";
            Cookie[] cookies = request.getCookies(); // 쿠키에 있는걸 클라이언트로부터 담아와서 받아.
            for (Cookie cookie : cookies) // 쿠키 하나씩 뽑아준다. 키를 모르니 이름으로 잡아낸다.
            {
                String name = cookie.getName();
                String value = cookie.getValue();
                if (name.equals("secondName")){ //쿠키삭제 
                    cookie.setMaxAge(0);
                    response.addCookie(cookie); //덮어써질것임
                }else { //출력
                        content = content + "<div>"+name+","+value+"</div>";
                }
            }

            // display(HTML 관련된 부분이라 쿠키와는 관련없음)
            PrintWriter printWriter = response.getWriter();

            printWriter.println(content);
            printWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
