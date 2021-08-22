import java.sql.*;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConexionDB {
	private static String servername = "localhost";
	private static String username = "root";
	private static String dbname = "Final";
	private static Integer portnumber = 3306;
	private static String password = "angel123";    
	
	public static Connection getConnection() {
        Connection con = null;
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        try {
			con = datasource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return con;
    }

}
