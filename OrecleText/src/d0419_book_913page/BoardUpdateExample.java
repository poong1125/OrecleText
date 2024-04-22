package d0419_book_913page;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample {

	public static void main(String[] args) {
		Connection conn =null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe","C##green","green1234");
			String sql = new StringBuilder()
					.append("UPDATE boards SET ")
					.append("btitle=?, ")
					.append("bcontent=?, ")
					.append("bfilename=?, ")
					.append("bfiledata=? ")
					.append("WHERE bno=?")
					.toString();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "손흥민");
			pstmt.setString(2, "고트흥");
			pstmt.setString(3, "C//Dae.jpg");
			pstmt.setBlob(4,  new FileInputStream("C:\\Dae2.jpg"));
			pstmt.setInt(5,5);
			
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 행 수 : " + rows);
			
			pstmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
					
				}catch(SQLException e) {}
			}
		}
	}

}
