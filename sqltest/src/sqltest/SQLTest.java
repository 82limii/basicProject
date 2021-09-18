package sqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLTest {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LSL", "java");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM ACCOMODATION");
		while (resultSet.next()) {
			String accId = resultSet.getString("acc_id");
			String accName = resultSet.getString("acc_name");
			String accAddr = resultSet.getString("acc_addr");
			String accTel = resultSet.getString("acc_tel");
			String accRate = resultSet.getString("acc_rate");
			System.out.printf("%s\t%s\t%s\t%s\t%s", accId, accName, accAddr, accTel, accRate);
			System.out.println();
		}
		resultSet.close();
		statement.close();
		connection.close();
	}
}
