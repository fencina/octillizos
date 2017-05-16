package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import java.util.concurrent.ThreadLocalRandom;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

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

		double valorAptitud = 0;

		ArrayList<Pista> pistas = getPistas();

		for (Pista pista : pistas ) {
			valorAptitud += pista.resolver();
		}

		return valorAptitud;
	}

    public ArrayList<Pista> getPistas() {

       ArrayList<Pista> pistas = new ArrayList<Pista>();

       pistas.add(new PistaUno(getPerfumes()));
       pistas.add(new PistaDos(getPerfumes()));
       pistas.add(new PistaTres(getPerfumes()));
       pistas.add(new PistaCuatro(getPerfumes()));
       pistas.add(new PistaCinco(getPerfumes()));
       pistas.add(new PistaSeis(getPerfumes()));
       pistas.add(new PistaSiete(getPerfumes()));
       pistas.add(new PistaOcho(getPerfumes()));
       pistas.add(new PistaNueve(getPerfumes()));

       return pistas;
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
			mensaje += "Perfume: " + perfume.getNombre() + "\n";
			mensaje += "Aroma: " + perfume.getAroma() + "\n";
		}

		return mensaje;
	}
}
