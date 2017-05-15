package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.logging.Logger;

public class PerfumeUtils {
	
	public static ArrayList<String> buildNamesArray() {

		ArrayList<String> nombres = new ArrayList<String>();
		nombres.add("Tommy");
		nombres.add("D&G");
		nombres.add("Polo");

		return nombres;
	}

	public static ArrayList<String> buildSmellsArray() {

		ArrayList<String> aromas = new ArrayList<String>();
		aromas.add("citrico");
		aromas.add("frutal");
		aromas.add("amaderado");

		return aromas;
	}

	public static ArrayList<Integer> buildLocationsArray() {

		ArrayList<Integer> ubicaciones = new ArrayList<Integer>();
		ubicaciones.add(1);
		ubicaciones.add(2);
		ubicaciones.add(3);

		return ubicaciones;
	}

	public static ArrayList<Perfume> buildRandomCombination() {
		ArrayList<String> nombres = PerfumeUtils.buildNamesArray();
		ArrayList<String> aromas = PerfumeUtils.buildSmellsArray();
		ArrayList<Integer> ubicaciones = PerfumeUtils.buildLocationsArray();

		ArrayList<Perfume> combinacion = new ArrayList<Perfume>();
		Integer iterations = ubicaciones.size();

		for (int i = 0 ; i < iterations ; i++) {
			Perfume perfume = new Perfume();

			// Get random name and remove it from array
			int randomIndex = ThreadLocalRandom.current().nextInt(0, nombres.size());
			
			perfume.setNombre(nombres.get(randomIndex));
			nombres.remove(randomIndex);

			// Get random smell and remove it from array
			randomIndex = ThreadLocalRandom.current().nextInt(0, aromas.size());
			perfume.setAroma(aromas.get(randomIndex));
			aromas.remove(randomIndex);

			// Get random location and remove it from array
			randomIndex = ThreadLocalRandom.current().nextInt(0, ubicaciones.size());
			perfume.setUbicacion(ubicaciones.get(randomIndex));
			ubicaciones.remove(randomIndex);

			combinacion.add(perfume);
		}

		return combinacion;
	}

}
