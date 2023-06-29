package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/session/CreateServlet")
public class SessionCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // get params from query //user에게 로그인 내용을 받아 날아올때
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // display
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<div>Create Session Servlets</div>");
            // login

            HttpSession httpSession = request.getSession(false); // Session이 있으면 쓰고 없으면 만들어줌(create여부를 결정)
            String usernameSession = (String) httpSession.getAttribute("username");
            if (httpSession != null && usernameSession != null) { // JSESSION 있음 - 로그인 되었다는 표시가 됨
                printWriter.println("<div>username : "+usernameSession+"</div>");
            } else { // JSESSION 없음 - 로그인을 다시 해야 하는 상태
                if ("yojulab".equals(username) && "1234".equals(password)) {
                    httpSession = request.getSession();
                    httpSession.setAttribute("username", username);
                    httpSession.setAttribute("password", password);
                    printWriter.println("<div>" + username + ", " + password + "</div>");
                } else {
                    printWriter.println("<div>Faild</div>");
                }


            // // 이름 말고 넘버링 해주는 인스턴스화.getSession을 하면 서버에서 유니크 아이디 설정. 다시 들어올 경우 로그인한사람인지 아닌지
            // // 알수있음.
            // // if문 밖으로 뺀 경우 jsession아이디가 없으면 (클라이언트 상태값에 따라) 만들어낸다.
            // //비교를 해서 없으면 만들어준다 
            // HttpSession httpSession = request.getSession(false);
            // if (httpSession != null) {// JSESSION 있음- 로그인되었다는 표시. 이미 서버에 같은 아이디 있다는 소리니까 해당되는 정보를 가지고 오기만 하면 됨.
            //     String usernameSession = (String) httpSession.getAttribute("username");
            //     //html에 표시
            //     printWriter.println("<div>username : "+usernameSession+"</div>");

            // } else { // 없음 - 로그인 
            //     // http 세션을 가져오기 위한 작업 // 내부에 request에서 온 값과 기존의 값을 비교 (있는지 없는지)
            //     if ("yojulab".equals(username) && "1234".equals(password)) {
            //          httpSession = request.getSession();
            //         // setAttribute하면 parameter 들어가. 스프링 자바에서 쓸때는 getParameter가 아니고 setAttribute.
            //         // (JSP로 넘길때)
            //         httpSession.setAttribute("username", username);
            //         httpSession.setAttribute("password", password);
            //         printWriter.println("<div>" + username + ", " + password + "</div>");

            //     } else {
            //         printWriter.println("<div>Faild</div>");
            //     }

            }

            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// 서버에서만 이거 갖고 있다 DECB0BEE8790F4B2968E6D79AA982D97
// getanddeleteservlet에서 들어가도 jsessionid가 같다
// 그래서 로그인 로그아웃 상태 유지 가능하다
