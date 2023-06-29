package com.example.study_servlet.controlls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// /helloWorldJSPServlet?company="YoJuLab"
@WebServlet(urlPatterns = "/helloWorldJSPServlet")
public class HelloWorldJSPServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
        try {
            // String contents = "Yoju Lab !";
            String contents = request.getParameter("company"); //사용자가 나한테 정보 넘김 
           
           
            // url 에서 가져오는 것 getparam. 응용프로그램 내에서 호출하는것 get attribute나 set attribute 사용. 
            //해쉬맵과 비슷. / 뒤에 있는 게 변수값이어서 나중에 key로 빼야함. 
            request.setAttribute("contents", contents);//그 정보를 나는 jsp로 넘김 
            //다음 파일 호출  
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloworldJSP.jsp"); //어디로 갈건지. 
            requestDispatcher.forward(request, response); //갖고 있는 정보를 모두 넘겨줘 request로. 
           
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}