/*
 * DB 테이블 구조
 * CREATE TABLE TEST(
 * NO NUMBER(10) PRIMARY KEY,
 * NAME VARCHAR2(30),
 * BIRTH NUMBER(20));
 * ---------------------
 * NO(PK)   NAME   BIRTH
 * ---------------------
 */


package _DataInput;

import javax.swing.JLabel;
import java.sql.*; 

public class Database {
	
	public Database(String getno, String getname, String getbirth, JLabel jl4) {
		
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	    String DB_USER = "Enter ID";
	    String DB_PASSWORD = "Endter PW";
	    
	    Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = null;
        
        String inputname = "'"+getname+"'";
        
        String query = "SELECT * FROM test";
        
        sql = "insert into test values("+ getno + " , " + inputname + " , " + getbirth +")";
		
		 try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            System.out.print("JDBC 연결 완료\n");
	        } catch (ClassNotFoundException e ) {
	           System.out.println("JDBC 드라이버 로드 실패");
	        }

	        try {
	            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	            stmt = conn.createStatement();
	            stmt.executeUpdate(sql);
	            rs = stmt.executeQuery(query);

	            while (rs.next()) { 
	                String NO = rs.getString(1);
	                String NAME = rs.getString(2);
	                String ID = rs.getString(3);
	                System.out.println(NO + " " + NAME + " " + ID); 
	            }
	        } catch ( Exception e ) {
	            e.printStackTrace();
	        } finally {
	            try {
	                rs.close();
	                stmt.close();
	                conn.close();
	            } catch ( SQLException e ) {}
	        }	
		jl4.setText("데이터가 입력되었습니다.");
	}
}
