package Factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConexionBase {

	private DataSource datasource;
	
	public ConexionBase() {
		ComboPooledDataSource comboPool = new ComboPooledDataSource();
		comboPool.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone"
				+ "=true&serverTimeZone=UTC");
		comboPool.setUser("root");
		comboPool.setPassword("delangelxavier");
		this.datasource = comboPool;
	}
	
	/*public Connection conectarBase() {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			System.out.println("Hubo un error");
			throw new RuntimeException(e);
		} */
		
		public Connection recuperarConexion() {
			try {
				return this.datasource.getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
	}
}
