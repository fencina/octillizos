package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

public class Perfume {
	
	private String nombre;
	private Integer ubicacion;
	private String aroma;

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getAroma() {
		return aroma;
	}
	
	public void setAroma(String aroma) {
		this.aroma = aroma;
	}

	public Integer getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}
}
