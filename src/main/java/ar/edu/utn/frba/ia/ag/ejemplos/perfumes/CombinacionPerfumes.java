package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

import java.util.ArrayList;
import java.util.Collections;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas.PistaUno;

public class CombinacionPerfumes extends Individuo {
	
	private ArrayList<Perfume> perfumes;

	@Override
	public Individuo generarRandom() {
		
		CombinacionPerfumes combinacion = new CombinacionPerfumes();

		combinacion.setPerfumes(PerfumeUtils.buildRandomCombination());

		return combinacion;
	}
	
	@Override
	public double aptitud() {

		// TODO - Crear todas las pistas e ir acumulando la aptitud segun la resolucion de cada una
		// aptitud = 0;
		// foreach( pistas as pista) {
		//		aptitud += pista.resolver(); }
		// return aptitud;

		PistaUno pista = new PistaUno(getPerfumes());
		return pista.resolver();
	}

	public ArrayList<Perfume> getPerfumes() {
		return perfumes;
	}
	
	public void setPerfumes(ArrayList<Perfume> perfumes) {
		this.perfumes = perfumes;
	}
	
	@Override
	public String toString() {

		String mensaje = "";

		Collections.sort(perfumes);

		for (Perfume perfume : perfumes ) {
			mensaje += "\nUbicacion: " + perfume.getUbicacion() + "\n";
			mensaje += "Perfume: " + perfume.getNombre().getString() + "\n";
			mensaje += "Aroma: " + perfume.getAroma() + "\n";
		}

		return mensaje;
	}
}
