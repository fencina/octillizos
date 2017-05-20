package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

public class Perfume {
	
	private NombresEnum nombre;
//	private Integer ubicacion;
	private AromasEnum aroma;

//	@Override
//	public int compareTo(Perfume perfume)
//	{
//	     return(ubicacion - perfume.getUbicacion());
//	} SI IMPLEMENTA COMPARABLE
	
	public NombresEnum getNombre() {
		return this.nombre;
	}
	
	public void setNombre(NombresEnum nombre) {
		this.nombre = nombre;
	}
	
	public AromasEnum getAroma() {
		return aroma;
	}
	
	public void setAroma(AromasEnum aroma) {
		this.aroma = aroma;
	}

//	public Integer getUbicacion() {
//		return ubicacion;
//	}
//	
//	public void setUbicacion(Integer ubicacion) {
//		this.ubicacion = ubicacion;
//	}
}
