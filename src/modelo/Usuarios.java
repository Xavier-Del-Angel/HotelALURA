package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Factory.ConexionBase;

public class Usuarios {

	private String nombre;
	private String contraseña;
	
	public Usuarios(String nombre, String contaseña) {
		this.nombre = nombre;
		this.contraseña = contaseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contraseña;
	}

	public void setContrasenia(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public static boolean validarUsuario(String nombre, String contaseña) {
		ConexionBase conexion = new ConexionBase();
		Connection connection = null;
		PreparedStatement state = null;
		ResultSet result = null;
		try {
			connection = conexion.recuperarConexion();
			state = connection.prepareStatement("SELECT * FROM ususarios WHERE nombre=? AND contraseña=?");
			state.setString(1, nombre);
			state.setString(2, contaseña);
			result = state.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(result !=null)
					result.close();
				if(state !=null)
					state.close();
				if(connection !=null)
					connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
