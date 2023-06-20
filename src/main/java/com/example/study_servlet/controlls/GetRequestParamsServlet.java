package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/getRequestParamsServlet")
public class GetRequestParamsServlet extends HttpServlet {
    @Override //상속이 된걸 확장 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // PrintWriter printWriter = response.getWriter();
            // String contents = "";
            // printWriter.println(contents);
            // printWriter.close();
            String firstName = request.getParameter("first_name");
            String secondName = request.getParameter("second_name");
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
                    "    <div>first Name : "+firstName+"</div>\r\n" + // 변수로 실어보내준다.
                    "    <div>second Name : "+secondName+"</div>\r\n" + //
                    "</body>\r\n" + //
                    "</html>";
            printWriter.println(contents); //화면 display가 terminal이 아니라 네트워크에 실어 보내는 것, 화면 display가 terminal이 아니라 네트워크에 실어 보내서 웹 화면상에 표현된다.
            printWriter.close(); //자원을 사용했으면 꼭 반납해줘야 함.
           

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
