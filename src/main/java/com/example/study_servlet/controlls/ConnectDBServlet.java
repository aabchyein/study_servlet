package com.example.study_servlet.controlls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/connectDBServlet")
public class ConnectDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.31:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            // - query Edit
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query);// resultset은 재활용 가능
            while (resultSet.next()) {
                System.out.println(resultSet.getString("COMPANY_ID") + resultSet.getString("COMPANY"));
            }

            // SELECT COUNT(*) AS CNT FROM factorys;
            query = "SELECT COUNT(*) AS CNT FROM factorys";
            resultSet = statement.executeQuery(query);
            resultSet.next();
            int totalCount = 0;
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("CNT"));
                totalCount = resultSet.getInt("CNT");
            } // while문 없어도 작동하지만 그래도 통일성 있게 주는거임

            // INSERT INTO factorys
            // (COMPANY_ID, COMPANY)
            // VALUE
            // ('CAR-01', 'AUDI') ; 테이블 없이 아웃풋 나옴
            // 변수로 만들어주고 query에 넣는게 좋음. 쿼리 뒤에 띄어쓰기 한번씩 하기

            String companyId = "CAR-01";
            String company = "AUDI";
            query = "INSERT INTO factorys " +
                    "(COMPANY_ID, COMPANY) " +
                    " VALUE " +
                    "('" + companyId + "', '" + company + "') ";

            int count = statement.executeUpdate(query); // intert update delete는 executeupdate쓴다. select문 빼고.

            // update factorys
            // SET COMPANY = '패러리'
            // WHERE COMPANY_ID = 'CAR-01' ;

            companyId = "CAR-01";
            company = "패러리";

            query = "UPDATE factorys " +
                    "SET COMPANY = ('" + company + "') " +
                    "WHERE COMPANY_ID = ('" + companyId + "') ";

            count = statement.executeUpdate(query);

            //DELETE FROM factorys
            // WHERE COMPANY_ID = 'CAR-01'

             companyId = "CAR-01";


             query = "DELETE FROM factorys " +
                     "WHERE COMPANY_ID = ('" + companyId + "') ";

              count = statement.executeUpdate(query);

            System.out.println();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}
