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
        
        System.out.println("SQL ���� �Է��ϼ��� (alter / insert / delete) : ");
        sql = sc.nextLine();
        sc.close();
        String query = "SELECT * FROM test";

        try {
            // ����̹��� �ε��Ѵ�.
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.print("JDBC ���� �Ϸ�\n");
        } catch (ClassNotFoundException e ) {
           System.out.println("����̹� �ε� ����");
        }

        try {
            // �����ͺ��̽��� ������ �����Ѵ�.
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Statement�� �����´�.
            stmt = conn.createStatement();
            // SQL���� �����Ѵ�.

            stmt.executeUpdate(sql);
            
            rs = stmt.executeQuery(query);

            while (rs.next()) { 
                String NUM = rs.getString(1);
                String NAME = rs.getString(2);
                String ID = rs.getString(3);
                // ����� ����Ѵ�.
                System.out.println(NUM + " " + NAME + " " + ID); 
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                // ResultSet�� �ݴ´�.
                rs.close();
                // Statement�� �ݴ´�.
                stmt.close();
                // Connection�� �ݴ´�.
                conn.close();
            } catch ( SQLException e ) {}
        }
    } // main()�� ��
} // Ŭ������ ��