package com.zeus.escuelas.domain;

public class EscuelaDomain {
	
	private long   idEscuela;
	private String nombreEscuela;
	private String direccion;
	private String telefono;
	private String especialidad;
	
	public void setIdEscuela(long idEscuela){
		this.idEscuela = idEscuela;
	}
	
	public long getIdEscuela() {
		return idEscuela;
	}
	
	public String getNombreEscuela() {
		return nombreEscuela;
	}
	public void setNombreEscuela(String nombreEscuela) {
		this.nombreEscuela = nombreEscuela;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public String toString() {
		String buffer;
		buffer = "idEscuela[ " + idEscuela + " ]  ";
		buffer += "nombreEscuela[ " + nombreEscuela + " ]  ";
		buffer += "direccion[ " + direccion + " ]  ";
		buffer += "telefono[ " + telefono + " ]  ";
		buffer += "especialidad[ " + especialidad + " ]  ";
		return buffer;
	}

}
