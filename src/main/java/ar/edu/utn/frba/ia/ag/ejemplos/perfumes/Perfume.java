package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

public class Perfume implements Comparable<Perfume> {
	
	private NombresEnum nombre;
	private Integer ubicacion;
	private String aroma;

	@Override
	public int compareTo(Perfume perfume)
	{
	     return(ubicacion - perfume.getUbicacion());
	}
	
	public NombresEnum getNombre() {
		return this.nombre;
	}
	
	public void setNombre(NombresEnum nombre) {
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
