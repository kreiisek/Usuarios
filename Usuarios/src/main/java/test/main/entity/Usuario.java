package test.main.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity//Indentificador de identidad
@Table(name = "Usuarios")//tabla
public class Usuario {
	
	@Id//PK
	@NotEmpty//Not null
	@Column(name = "NoEmpleado", unique = true ,length = 6)//Add column
	private String noEmpleado;
	
	@Column(name= "NombreCompleto", length = 100 )
	private String nombreCompleto;
	

	@Temporal(TemporalType.DATE)//Descompe el tipo DATE
	@NotEmpty
	@Column(name= "FechaNacimiento")
	private Date fechaNacimiento;
	

	@Column(name = "Celular", length = 10  )
	@NotEmpty
	private String celular;
	

	@Column(name = "Estatus", length = 1 )
	@NotEmpty
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


	public void setEstatus(String sstatus) {
		this.estatus = sstatus;
	}




	public Usuario(@NotEmpty String noEmpleado, String nombreCompleto, @NotEmpty Date fechaNacimiento,
			@NotEmpty String celular, @NotEmpty String estatus) {
		super();
		this.noEmpleado = noEmpleado;
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.estatus = estatus;
	}


	public Usuario() {

	}
	
	
	
	
	

}
