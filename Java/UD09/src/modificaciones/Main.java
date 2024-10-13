package modificaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
	public static void main(String[] args) {
		String connectionURL = "jdbc:mariadb://dbalumnos.sanclemente.local:3319/yvr_empresa";
		try(Connection con = (Connection) DriverManager.getConnection(connectionURL, "alumno", "abc123..")){
			try(Statement s = con.createStatement()){
				int registros_afectados = s.executeUpdate("UPDATE employees SET salary = 40000 WHERE emp_id = 107");
				System.out.println(registros_afectados);
				String tableSql = "CREATE TABLE IF NOT EXISTS prueba" 
						  + "(emp_id int PRIMARY KEY AUTO_INCREMENT, name varchar(30),"
						  + "position varchar(30), salary double)";
				s.execute(tableSql);
				s.executeUpdate("INSERT INTO employees"+"(emp_id, name, posicion, salary)"+
				"VALUES(108, 'Yago Vila', 'secretario', '30000')");
				s.executeUpdate("DELETE FROM employees WHERE emp_id = 107");
			}finally {
				con.close();
			}
		}catch(SQLException e) {
			System.out.println("Error en la conexión");
		}
	}	
}


