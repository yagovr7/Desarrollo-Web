package prueba;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class conexiónMúltiplesOpciones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
			    }
			}
			//******************Buscando por ID******************************
			String consulta = "SELECT * FROM employees WHERE emp_id = ?"; 
			PreparedStatement ps = con.prepareStatement(consulta);
			System.out.print("ID empleado: ");
			String id = sc.next();
			ps.setString(1, id);
			try (ResultSet resultSet = ps.executeQuery();) {
				List<Employee> employeess = new ArrayList<>(); 
			    while (resultSet.next()) { 
			        Employee empp = new Employee(); 
			        empp.setId(resultSet.getInt("emp_id")); 
			        empp.setName(resultSet.getString("name")); 
			        empp.setPosition(resultSet.getString("posicion")); 
			        empp.setSalary(resultSet.getDouble(4)); 
			        employeess.add(empp); 
			    }
			    for(Employee st: employeess) {
			    	System.out.println("Posición: "+st.getPosition()+"\t Salario: "+st.getSalary()+" €");
			    }
		    }
			
			String consulta2 = "SELECT sum(salary) FROM employees"; 
			PreparedStatement pss = con.prepareStatement(consulta2);
			try (ResultSet resultSet2 = pss.executeQuery();) {
				double total = 0;
			    while (resultSet2.next()) { 
			         total = total+resultSet2.getDouble(1);
			    }
			    System.out.println("Total salarios: "+total+" €");
		    }
			
			String consulta3 = "SELECT * FROM employees WHERE salary >= ? and posicion = ?";
			PreparedStatement psss = con.prepareStatement(consulta3);
			psss.setString(1, "45000");
			psss.setString(2, "jefe");
			try (ResultSet resultSet3 = psss.executeQuery();) {
				resultSet3.next();
				System.out.println("Respuesta a la consulta: "+resultSet3.getInt(1));
		    }

		}catch(SQLException e) {
			System.out.println("Error en la conexión");
		}
	}	
}
