package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/MynameRequestServlet") //폼테그 띄우기 위한 것 
public class MynameRequestServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   try {
     PrintWriter printWriter = response.getWriter();
     String contents = "<!DOCTYPE html>\r\n" + //
             "<html lang=\"en\">\r\n" + //
             "<head>\r\n" + //
             "    <meta charset=\"UTF-8\">\r\n" + //
             "    <meta name=\"viewport\" content=\"width=<device-width>, initial-scale=1.0\">\r\n" + //
             "    <title>Document</title>\r\n" + //
             "</head>\r\n" + //
             "<body>\r\n" + //
             "    <div>input your name</div>\r\n" + //
             "    <form action=\"http://192.168.0.39:8080/getRequestParamsServlet\" method=\"get\"> <!--class\uC5D0\uB294 doget\uB9CC \uC4F4\uB2E4 + \uC5EC\uAE30\uC5D4 get \uC4F4\uB2E4   -->\r\n" + //
             "    <div>\r\n" + //
             "        first name : <input type=\"text\" name=\"first_name\"> <!--\uAC12\uC774 \uB0A0\uC544\uAC10 -->\r\n" + //
             "    </div>\r\n" + //
             "    <div>\r\n" + //
             "        second name : <input type=\"text\" name=\"second_name\">\r\n" + //
             "    </div>\r\n" + //
             "    <div>\r\n" + //
             "        <button type=\"submit\">\uBCF4\uB0B4\uAE30</button>\r\n" + //
             "    </div>\r\n" + //
             "</form>\r\n" + //
             "</body>\r\n" + //
             "</html>";
     printWriter.println(contents);
     printWriter.close();

   } catch (Exception e) {
    System.out.println(e.getMessage());
   }
  }
}
