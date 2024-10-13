package RowSet;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Main {
	public static void main(String[] args) {
		JdbcRowSet rowSet;
		try {
		    //obtenemos el rowset de forma estatica
		    rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		    rowSet.setUrl("jdbc:mysql://dbalumnos.sanclemente.local:3319/yvr_empresa");

		    rowSet.setUsername("alumno");
		    rowSet.setPassword("abc123..");

		    // Asignamos consulta y ejecutamos 
		    rowSet.setCommand("select * from Person");
		    rowSet.execute();
		    while (rowSet.next()) {
                System.out.println("Id: "  + rowSet.getInt(1));
                System.out.println("Name: " + rowSet.getString(2));
                System.out.println("Posicion: " + rowSet.getString(3));
            }
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
