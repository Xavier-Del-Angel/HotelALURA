package Controladores;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import DAO.ReservacionDAO;
import Factory.ConexionBase;
import modelo.Reserva;

public class ReservacionControlador {

	private ReservacionDAO reservas;

	public ReservacionControlador() {
		Connection con = new ConexionBase().recuperarConexion();
		this.reservas = new ReservacionDAO(con);
	}
	
	public void guardar(Reserva res) {
		this.reservas.guardar(res);
	}
	
	public List<Reserva> buscar(){
		return this.reservas.buscar();
	}
	public List<Reserva> buscarId(String id){
		return this.reservas.buscarId(id);
	}
		
	public void actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
		this.reservas.Actualizar(fechaE, fechaS, valor,formaPago, id);
	}
	
	public void Eliminar(Integer id) {
		this.reservas.Eliminar(id);
	}
}
