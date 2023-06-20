package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/CheckoutResponseServlet")
public class CheckoutResponseServlet extends HttpServlet {
    @Override //상속이 된걸 확장 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // PrintWriter printWriter = response.getWriter();
            // String contents = "";
            // printWriter.println(contents);
            // printWriter.close();
            String First_name = request.getParameter("First_name");
            String Last_name = request.getParameter("Last_name");
            String User_name = request.getParameter("User_name");
            String Email = request.getParameter("Email");
            String Address = request.getParameter("Address");
            String Address2 = request.getParameter("Address2");
            String Country = request.getParameter("Country");
            String State = request.getParameter("State");
            String Zip = request.getParameter("Zip");
            
            //클라이언트가 넣은 값이 화면에 표시되게하기 위함. 
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
                    "    <div>First name : "+First_name+" </div>\r\n" + //
                    "    <div>Second name : "+Last_name+"</div>\r\n" + //
                    "    <div>User name: "+User_name+"</div>\r\n" + //
                    "    <div>Email: "+Email+"</div>\r\n" + //
                    "    <div>Address: "+Address+"</div>\r\n" + //
                    "    <div>Address2: "+Address2+"</div>\r\n" + //
                    "    <div>Country: "+Country+"</div>\r\n" + //
                    "    <div>State: "+State+"</div>\r\n" + //
                    "    <div>Zip: "+Zip+"</div>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "</html>";
            printWriter.println(contents); //화면 display가 terminal이 아니라 네트워크에 실어 보내서 웹 화면상에 표현된다.
            printWriter.close(); //자원을 사용했으면 꼭 반납해줘야 함.
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

