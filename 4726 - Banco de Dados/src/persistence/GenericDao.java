package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Criado pelo Prof. M.Sc. Leandro Colevati dos Santos
 */
public class GenericDao {

	private Connection con;

	public Connection getConnection() {

		try {

//			Class.forName("net.sourceforge.jtds.jdbc.Driver");
//			String url = "jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=aulajoin10;namedPipe=true";
//			con = DriverManager.getConnection( url, "fatec", "fatec");
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/aulajoin10";
			con = DriverManager.getConnection( url, "root", "root");
			
//			System.out.println("Conexao ok");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void fechaConexao() {
		try {
			if (con != null)
				con.close();
			con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
