package com.korit.servlet_study.ch10;

import java.sql.*;

/**
 *  JDBC JavaDataBaseConnection
 */

public class JDBCMain {
    public static void main(String[] args) {
        // http://naver.com      -> http 프로토콜
        // jdbc:mysql://ip:port  -> jdbc:mysql 프로토콜
        // mysql의 port: 기본(3306), 우리가 설정(3309)

        final String URL = "jdbc:mysql://localhost:3309/create_study";
        final String USERNAME = "root";
        final String PASSWORD = "1q2w3e4r";

        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");   // JDBC 4버전 이상부터는 생략 가능
            String sql = """
                    select * from student_tb where student_name = '김준일'
                    """;
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // database에 접속함.
            PreparedStatement ps = connection.prepareStatement(sql);
            // connetion.prepaedStatement 호출 후 PreparedStatement(코드 입력창) 객체 생성
            ResultSet rs = ps.executeQuery();
            // SQL 실행 결과(SELECT 결과)를 저장한 객체
            rs.next();
            int studentID = rs.getInt("student_id");
            String studentName = rs.getString("student_name");
            System.out.println("id: " + studentID);
            System.out.println("name: " + studentName);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터베이스 연결 실패");
        }
    }
}

