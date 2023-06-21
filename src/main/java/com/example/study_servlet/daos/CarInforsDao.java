package com.example.study_servlet.daos;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.study_servlet.commons.Commons;

public class CarInforsDao {
    public ArrayList selectAll() {
        ArrayList arrayList = new ArrayList<>();
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();
            String query = "SELECT * FROM car_infors";
            ResultSet resultSet = statement.executeQuery(query);
            HashMap hashMap = new HashMap();
            while (resultSet.next()) {
                hashMap = new HashMap();
                hashMap.put("CAR_NAME", resultSet.getString("CAR_NAME"));
                hashMap.put("YEAR", resultSet.getString("YEAR"));
                hashMap.put("CAR_INFOR_ID", resultSet.getString("CAR_INFOR_ID"));
                hashMap.put("COMPANY_ID", resultSet.getString("COMPANY_ID"));
                arrayList.add(hashMap);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
}
