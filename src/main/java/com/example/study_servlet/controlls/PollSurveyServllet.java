package com.example.study_servlet.controlls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlet.daos.PollsDao;

@WebServlet(urlPatterns = "/poll/SurveyServllet")
public class PollSurveyServllet extends HttpServlet{
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // String contents = "Yoju Lab !";
            String contents = request.getParameter("company");

            PollsDao pollsDao = new PollsDao();
            ArrayList surveyList = pollsDao.SelectWithSearch(contents); // surveyList는 내부에서 사용할 변수를 정해준 것.
            for(int i=0; i < surveyList.size(); i = i+3) {
                HashMap survey = (HashMap) surveyList.get(i); //List를 Hashmap으로 먼저 풀어줌
                String questions = (String) survey.get("QUESTIONS");// Hashmap을 풀어준다.
                System.out.println(questions);
                for(int e=0; e <3; e = e+1) {
                    survey = (HashMap) surveyList.get(e);
                    String choice =(String) survey.get("CHOICE");
                    System.out.println(choice);
                }
                
                
            }

            request.setAttribute("contents", contents);
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/surveys/survey.jsp"); // 브라우저에 띄웠던 경로를 적어줘야 함.
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


// html을 만들어서 확인하고 jsp만들어서 브라우저에서 작동되는 것 확인
// view를 먼저 띄워보고 servlet으로 jsp 만드는 것을 해결
// servlet을 만들면 servlet의 url로 호출을 해야 jsp가 출력이 된다.
// dispatcher 된다는 것은 jsp로 넘어간다는 것을 의미함