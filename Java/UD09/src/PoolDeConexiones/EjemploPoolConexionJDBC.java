package PoolDeConexiones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import E1_Modificaciones.Person;

public class EjemploPoolConexionJDBC {

    public static void main(String[] args) throws SQLException {
        // Configurar el pool de conexiones
        BasicDataSource dataSource = new BasicDataSource();
        //dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://dbalumnos.sanclemente.local:3319/yvr_empresa");
        dataSource.setUsername("alumno");
        dataSource.setPassword("abc123..");
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(10);
        
        dataSource.setValidationQuery("Select 1");
        // Obtener una conexión del pool
        Connection conn = dataSource.getConnection();
        
        List<Person> personas = null;
		String SLQ = "SELECT id,name,lastname,age FROM Person";
		Statement stmt = conn.createStatement();
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
			for(Person x: personas){
				System.out.println(x.getId()+" "+x.getName()+" "+x.getLastName()+" "+x.getAge());
			}
			
		}
        
        // Usar la conexión para enviar consultas
        // ...
        
        // Devolver la conexión al pool
        conn.close();
    }
}
