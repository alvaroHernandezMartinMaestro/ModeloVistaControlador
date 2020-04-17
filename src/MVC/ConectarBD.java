package MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectarBD {

	
	
	public String usuario = "root";
	public String contrase�a = "Studium2019;";
	public Statement statement;
	public Connection conectarBD() {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/empresa?serverTimezone=UTC";
		Connection con = null;
		try {
			
			// Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			// Establecer la conexi�n con la BD empresa
			con = DriverManager.getConnection(url, usuario, contrase�a);
			this.statement = con.createStatement();
			System.out.println(con);
			if (con != null) {
				System.out.println("Conectado a la base de datos");
			}
		} catch (SQLException ex) {
			System.out.println("ERROR:La direcci�n no es v�lida o el usuario y clave");
			ex.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error 1-" + cnfe.getMessage());
		}
		return con;
	}
	
	public ResultSet ejecutarQuery(String query) throws SQLException {
		return this.statement.executeQuery(query); 
	}
	
	
}