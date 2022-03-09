package test.main.DTO;

import java.util.Date;

//Data Transfer Object
public class UsuarioDTO {

	private String noEmpleado;
	private String nombreCompleto;
	private Date fechaNacimiento;
	private String celular;
	private String estatus;
	
	public String getNoEmpleado() {
		return noEmpleado;
	}
	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public UsuarioDTO(String noEmpleado, String nombreCompleto, Date fechaNacimiento, String celular, String estatus) {
		super();
		this.noEmpleado = noEmpleado;
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.estatus = estatus;
	}

	public UsuarioDTO() {

	}
	
	
	
	
	
	
	
}
