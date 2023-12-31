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

import com.example.study_servlet.commons.Commons;

@WebServlet(urlPatterns = "/CarInforsServlet")
public class CarInforsServlet extends HttpServlet {
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
            String query = "SELECT * FROM car_infors";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("CAR_NAME") + resultSet.getString("YEAR")
                                + resultSet.getString("CAR_INFOR_ID") + resultSet.getString("COMPANY_ID"));
            }

            // - INSERT QUERY
            Commons commons = new Commons();
            String carInforId = commons.generateUUID();
            query = "INSERT INTO car_infors\n" + //
                    "(CAR_NAME, YEAR, CAR_INFOR_ID, COMPANY_ID)\n" + //
                    "VALUES\n" + //
                    "('HyeIn', '2001', '"+carInforId+"', 'C004');";
            int count = statement.executeUpdate(query);

            query = "SELECT * FROM car_infors";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("CAR_NAME") + resultSet.getString("YEAR") + resultSet.getString("CAR_INFOR_ID") + resultSet.getString("COMPANY_ID"));
            }


            } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println();
    }



    //         Common commons = new Common();
    //         query = "insert into car_infors\n" + //
    //                 "(CAR_NAME, YEAR, CAR_INFOR_ID, COMPANY_ID)\n" + //
    //                 "values\n" + //
    //                 "('angelalala', '2000', '" + commons.generateUUID() + "', 'C005');";

    //         int count = statement.executeUpdate(query);

    //         query = "SELECT * FROM db_cars.car_infors;";
    //         resultSet = statement.executeQuery(query);
    //         while (resultSet.next()) {
    //             System.out.println(resultSet.getString("CAR_NAME") + resultSet.getString("YEAR")
    //                     + resultSet.getString("CAR_INFOR_ID") + resultSet.getString("COMPANY_ID"));
    //         }

    //     } catch (Exception e) {

    //         System.out.println(e.getMessage());
    //     }

    //     System.out.println();

    // }
}
