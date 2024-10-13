package E1_Modificaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Connect implements IPerson{
	static String sURL = "jdbc:mariadb://dbalumnos.sanclemente.local:3319/yvr_empresa"; 
	static Connection conexion;
	public Connection openConnection() throws SQLException {
		
		try {
			conexion = (Connection) DriverManager.getConnection(sURL, "alumno", "abc123..");
			System.out.println("Conexión exitosa");
		}catch(SQLException e) {
			System.out.println("Fallo en la conexión");
		}
		return null;
	}

	public int insertPerson(Connection connection, Person person) throws SQLException {
		try(PreparedStatement stmt = connection.prepareStatement("INSERT INTO Person VALUES(?,?,?,?)")){
			stmt.setInt(1, person.getId());
			stmt.setString(2, person.getName());
			stmt.setString(3, person.getLastName());
			stmt.setInt(4, person.getAge());
			return stmt.executeUpdate();
		}
	}

	public void updatePersonAgeById(Connection connection, int id, int newAge) throws SQLException {
		try(PreparedStatement stmt = connection.prepareStatement("UPDATE Person SET age=? WHERE id=?")){
			stmt.setInt(1, newAge);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		}
		
	}

	public List selectAllPeople(Connection connection) throws SQLException {
		List<Person> personas = null;
		String SLQ = "SELECT id,name,lastname,age FROM Person";
		Statement stmt = connection.createStatement();
		try(ResultSet resultado = stmt.executeQuery(SLQ)){
			personas = new ArrayList<>();
			while(resultado.next()) {
				Person p = new Person();
				p.setId(resultado.getInt("id"));
				p.setName(resultado.getString("name"));
				p.setLastName(resultado.getString("lastname"));
				p.setAge(resultado.getInt("age"));
				personas.add(p);
			}
			
		}
		return personas;
	}
	
	public static void main(String[] args) throws SQLException {
		Connect root = new Connect();
		Person p1 = new Person(5, "Yago", "Vila Rama", 26);
		try {
			root.openConnection();
			System.out.println("Filas afectadas: "+root.insertPerson(conexion, p1));
			root.updatePersonAgeById(conexion, 5, 27);
			root.selectAllPeople(conexion);
			List<Person> p = root.selectAllPeople(conexion);
			for(Person x: p) {
				System.out.println(x.getId()+x.getName()+x.getLastName()+x.getAge());
			}
		}catch(SQLException e) {
			System.out.println("Error");
		}
		
		
		
		
	}

}
