package BBDD_Prueba;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class conexiónMúltiplesOpciones {
	public static void main(String[] args) {
		String connectionURL = "jdbc:mariadb://dbalumnos.sanclemente.local:3319/yvr_empresa";
		try(Connection con = (Connection) DriverManager.getConnection(connectionURL, "alumno", "abc123..")){
			try (Statement stmt = con.createStatement()) {
				String selectSql = "SELECT * FROM employees"; 
				try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
					List<Employee> employees = new ArrayList<>(); 
				    while (resultSet.next()) { 
				        Employee emp = new Employee(); 
				        emp.setId(resultSet.getInt("emp_id")); 
				        emp.setName(resultSet.getString("name")); 
				        emp.setPosition(resultSet.getString("posicion")); 
				        emp.setSalary(resultSet.getDouble(4)); 
				        employees.add(emp); 
				    }
				    for(Employee st: employees) {
				    	System.out.println(st.getId()+"\t"+st.getName()+"\t"+st.getPosition()+"\t"+st.getSalary());
				    	
				    }
				}
			}
		}catch(SQLException e) {
			System.out.println("Error en la conexión");
		}
	}	
}
