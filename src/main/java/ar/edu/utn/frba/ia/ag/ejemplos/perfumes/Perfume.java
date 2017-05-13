package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import java.util.concurrent.ThreadLocalRandom;

public class Perfume extends Individuo {
	
	private String nombre;
	private Integer ubicacion;
	private String aroma;

	private static final String[] NOMBRES = {"Tommy", "Channel", "Polo"};
	private static final String[] AROMAS = {"citrico", "frutal", "amaderado"};
	private static final Integer[] UBICACIONES = {1, 2, 3};

	@Override
	public Individuo generarRandom() {
		
		Perfume perfume = new Perfume();
		perfume.setNombre(Perfume.getRandomName());
		perfume.setAroma(Perfume.getRandomSmell());
		perfume.setUbicacion(Perfume.getRandomLocation());

		return perfume;
	}
	
	@Override
	public double aptitud() {


		// TODO
		// aptitud = 0;
		// foreach( pistas as pista) {
		//		aptitud += pista.resolver(this); }
		// return aptitud;

		// Debera haber una ¿clase? por cada pista en el enunciado
		// que sepa resolverse para un perfume dado.
		// Se suman todas las resoluciones de las pistas para el perfume ( SUMATORIA(p*v) )
		return 1.1;
	}

	public static String getRandomStringFromArray(String[] array) {
		// Random generator = new Random();
		// int randomIndex = generator.nextInt(array.length);

		int randomIndex = ThreadLocalRandom.current().nextInt(0, array.length);
		return array[randomIndex];
	}

	public static String getRandomName() {
		return Perfume.getRandomStringFromArray(Perfume.NOMBRES);
	}
	
	public static String getRandomSmell() {
		return Perfume.getRandomStringFromArray(Perfume.AROMAS);
	}

	public static Integer getRandomLocation() {
		// Random generator = new Random();
		// int randomIndex = generator.nextInt(this.UBICACIONES.length);

		int randomIndex = ThreadLocalRandom.current().nextInt(0, Perfume.UBICACIONES.length);
		return Perfume.UBICACIONES[randomIndex];
	}

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
	
	@Override
	public String toString() {
		// TODO
		// return "x = " + x + " / f(x) = " + this.aptitud();
		return "TODO";
	}
}
