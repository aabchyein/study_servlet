package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/getRequestParamsServlet")
public class GetRequestParamsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String firstName = request.getParameter("first_name");
            String secondName = request.getParameter("second_name");
            PrintWriter printWriter = response.getWriter();
            // String contents = "Hye In kIm!";
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Heool World</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <div>first Name : "+firstName+"</div>\r\n" + // 변수로 실어보내준다.
                    "    <div>second Name : "+secondName+"</div>\r\n" + //
                    "</body>\r\n" + //
                    "</html>";
            printWriter.println(contents); //화면 display가 terminal이 아니라 네트워크에 실어 보내는 것.
            printWriter.close();
            // PrintWriter printWriter = response.getWriter(); //response.getWriter()를 네트워크에 실어보낸다.
            // String contents = "";
            // printWriter.println(contents);
            // printWriter.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
