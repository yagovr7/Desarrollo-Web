package Ejercicio1;


import java.sql.Connection;
import java.sql.DriverManager;
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
				  //******************Buscando por ID***************************
				    System.out.print("ID del empleado: ");
				    int id = sc.nextInt();
				    double totalSalarios = 0;
				    int comprobar = 0;
				    for(Employee sx: employees) {
				    	if(sx.getId()==id) {
				    		comprobar=1;
				    	}
				    }
				    while(comprobar==0) {
				    	System.out.print("ID incorrecto vuelve a introducirlo: ");
				    	id = sc.nextInt();
				    	for(Employee sx: employees) {
					    	if(sx.getId()==id) {
					    		comprobar=1;
					    	}
					    }
				    }
				    for(Employee st: employees) {
				    	if(st.getId()==id) {
					    	System.out.println("Posición: "+st.getPosition()+"\t Salario: "+st.getSalary()+" €");
					    	break;
				    	}
				    }
				    //****************Total Salarios********************************
				    for(Employee x: employees) {
				    	totalSalarios=totalSalarios+x.getSalary();
			    	}
				    System.out.println("Total salarios: "+totalSalarios+" €");
				  //************Empleados con mayor salario que y posicion**********
				    System.out.print("Salario a comparar: ");
				    double salario = sc.nextDouble();
				    System.out.print("Posicion a comparar: ");
				    String posicion = sc.next();
				    
				    int count = 0;
				    for(Employee em: employees) {
				    	if(em.getSalary()>=salario&&em.getPosition().equals(posicion)) {
				    		count+=1;
				    	}
				    }
				    System.out.println("Total de empleados con un salario mayor que "+salario+
				    		" € y con la posicion "+posicion+": "+count);
				    
				    
			    }
			}
		}catch(SQLException e) {
			System.out.println("Error en la conexión");
		}
	}	
}
