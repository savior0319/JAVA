package _Oracle;

import java.sql.*; 
import java.util.*;

public class Test {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
        String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
        String DB_USER = "ID";
        String DB_PASSWORD = "PW";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = null;
        
        System.out.println("SQL 문을 입력하세요 (alter / insert / delete) : ");
        sql = sc.nextLine();
        sc.close();
        String query = "SELECT * FROM test";

        try {
            // 드라이버를 로딩한다.
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.print("JDBC 연결 완료\n");
        } catch (ClassNotFoundException e ) {
           System.out.println("드라이버 로드 실패");
        }

        try {
            // 데이터베이스의 연결을 설정한다.
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Statement를 가져온다.
            stmt = conn.createStatement();
            // SQL문을 실행한다.

            stmt.executeUpdate(sql);
            
            rs = stmt.executeQuery(query);

            while (rs.next()) { 
                String NUM = rs.getString(1);
                String NAME = rs.getString(2);
                String ID = rs.getString(3);
                // 결과를 출력한다.
                System.out.println(NUM + " " + NAME + " " + ID); 
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                // ResultSet를 닫는다.
                rs.close();
                // Statement를 닫는다.
                stmt.close();
                // Connection를 닫는다.
                conn.close();
            } catch ( SQLException e ) {}
        }
    } // main()의 끝
} // 클래스의 끝