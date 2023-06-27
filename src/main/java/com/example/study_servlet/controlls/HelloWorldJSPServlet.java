package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldJSPServlet")
public class HelloWorldJSPServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
        try {
            // String contents = "Yoju Lab !";
            String contents = request.getParameter("company"); //getParameter로 값을 받아서 attribute로 값을 세팅.


            request.setAttribute("contents", contents);
            //다음 파일 호출  
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloworldJSP.jsp"); //어디로 갈건지. 
            requestDispatcher.forward(request, response); //갖고 있는 정보를 모두 넘겨줘 request로. 
           
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}