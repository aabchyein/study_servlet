package com.example.study_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlet.commons.Commons;
import com.example.study_servlet.daos.OptionInforsDao;

//혜인
// @WebServlet(urlPatterns = "/optionInforsInsertServlet")
// public class OptionInforsInsertServlet extends HttpServlet {
//     @Override
//     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         try {
//             String name = request.getParameter("name");

//             OptionInforsDao optionInforsDao = new OptionInforsDao();
//             int count = optionInforsDao.OptionInforsInsertServlet(name);

//             response.setContentType("text/html;charset=UTF-8");
//             PrintWriter printWriter = response.getWriter();
//             String contents = "Insert count :"+count;
//             printWriter.println(contents);
//             printWriter.close();

 import com.example.study_servlet.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforsInsertServlet")
public class OptionInforsInsertServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String option_infor_id = request.getParameter("name");

        OptionInforsDao optionInforsDao = new OptionInforsDao();
        int count = optionInforsDao.Insert(option_infor_id);

       response.setContentType("text/html;charset=UTF-8");
       PrintWriter printWriter = response.getWriter();
       String contents = "Insert count: " +count;
       
       printWriter.println(contents);
       printWriter.close();







        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
