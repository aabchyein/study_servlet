package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlet.commons.Commons;
import com.example.study_servlet.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforsJSPServlet")
public class OptionInforsJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String search = request.getParameter("search");
           
            OptionInforsDao optionInforsDao = new OptionInforsDao();
            ArrayList optionInforList = new ArrayList();// OptionInforsDao 클래스에서 결과값으로 넘어온 arraylist를 받을 공간을 마련함( 리턴값과 받을 공간의 data type이 동일해야 함)
            optionInforList = optionInforsDao.SelectWithSearch(search);

            request.setAttribute("search", search);
            request.setAttribute("optionInforList", optionInforList);

            // getWriter전에 charset 하기 (html파일에서 한글이 깨지지 않게 해줌)
            response.setContentType("text/html;charset=UTF-8");
            
            //다음 파일 호출  
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cars/option_infors.jsp"); //어디로 갈건지. 
            requestDispatcher.forward(request, response);

            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
