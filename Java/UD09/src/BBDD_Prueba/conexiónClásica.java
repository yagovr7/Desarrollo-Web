package BBDD_Prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexiónClásica {
	public static boolean isConnectionValid(Connection connection)
	{
	    try {
	        if (connection != null && !connection.isClosed()) {
	            // Running a simple validation query
	            connection.prepareStatement("SELECT 1");
	            return true;
	        }
	    }
	    catch (SQLException e) {
	        System.out.println(e.getErrorCode());
	    }
	    return false;
	}
	public static void main(String[] args) {
		Connection con = null;
		
		  String sURL = "jdbc:mariadb://dbalumnos.sanclemente.local:3319/test";
		  try {
			  con = (Connection) DriverManager.getConnection(sURL,"alumno","abc123..");
			  System.out.println ("¡Conexión exitosa!");
			  System.out.println(isConnectionValid(con));
		  }catch(Exception e) {
			  System.out.println("Error en la conexión: "+e.toString());
		  }finally {
			  try {
				  if(con!=null) {
					  con.close();
				  }
			  }catch(Exception e) {
				  System.out.println("Error cerrando conexiones: "+e.toString());
			  }
		  }
		  		
	}
}
