package Factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {

	public static void main(String[] args) throws SQLException {
		ConexionBase conexion = new ConexionBase();
		Connection conection = conexion.recuperarConexion();
		
		System.out.println("La porqueria Conecto");
		conection.close();
		System.out.println("Cerro bien");
	}
}
