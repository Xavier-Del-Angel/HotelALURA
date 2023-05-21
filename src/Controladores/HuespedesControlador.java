package Controladores;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import DAO.HuespedesDAO;
import Factory.ConexionBase;
import modelo.Huespedes;

public class HuespedesControlador {

	private HuespedesDAO huespedesDao;
	
	public HuespedesControlador() {
		Connection connection = new ConexionBase().recuperarConexion();
		this.huespedesDao = new HuespedesDAO(connection);
	}
	
	public void guardar(Huespedes huespedes) {
		this.huespedesDao.guardar(huespedes);
	}
	
	public  List<Huespedes> buscarHuespedes(){
		return this.huespedesDao.buscar();
	}
	
	public  List<Huespedes> buscarHuespedesId(String id){
		return this.huespedesDao.buscarId(id);
	}
	
	public void actualizar(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono,Integer id_reserva) {
		this.huespedesDao.Actualizar(nombre, apellido, fechaNacimiento, nacionalidad, telefono, id_reserva, id_reserva);
	}
	 
	public void Eliminar(Integer idReserva) {
		this.huespedesDao.Eliminar(idReserva);
	}
	
}
