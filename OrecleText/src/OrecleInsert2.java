import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class OrecleInsert2 {

	public static void main(String[] args) {
		int zz=0;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##green";
		String password = "green1234";
		
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println("oracle connection sucesss.\n");
			Statement stmt = conn.createStatement();
			
			String sql2 = "SELECT deptno FROM dept";
			ResultSet rs = stmt.executeQuery(sql2);
			while(rs.next()) {
			zz=Integer.parseInt(rs.getString("deptno"));
			}
			int baem = zz+10;
			String real = Integer.toString(baem);
		
			String sdname="IT",sloc="SEOUL";
			String sql = "INSERT INTO dept VALUES ('" + real + "','" + sdname +"','" + sloc +"')";
			boolean b = stmt.execute(sql);
			if(!b) {
				System.out.println("Insert success.\n");
			}else {
				System.out.println("Insert fail.\n");
			}
			
			sql2 = "SELECT deptno,dname,loc FROM dept ORDER BY deptno";
			rs = stmt.executeQuery(sql2);
			while(rs.next()) {
				System.out.print(rs.getString("deptno") +"\t");
				System.out.print(rs.getString("dname")+"\t");
				System.out.println(rs.getString("loc") + " ");
			}
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}catch(SQLException e) {
			System.out.println(e);

		}
	}

}
