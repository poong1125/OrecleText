package d0418_Login;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InfoDAO1 {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "C##green";
	String password = "green1234";
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public ArrayList<InfoVo1> list(){
		ArrayList<InfoVo1> list = new ArrayList<InfoVo1>();
		
		try {
			connDB();
			
			String query = "SELECT id,password FROM Login";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("PASSWORD");
				
				InfoVo1 data = new InfoVo1(id,pwd);
				list.add(data);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url,user,password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement();
			System.out.println("statement create success.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

