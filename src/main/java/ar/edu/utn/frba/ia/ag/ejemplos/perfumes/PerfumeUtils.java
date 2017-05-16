package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class PerfumeUtils {
	
	public static ArrayList<Integer> buildLocationsArray() {

		ArrayList<Integer> ubicaciones = new ArrayList<Integer>();
		ubicaciones.add(1);
		ubicaciones.add(2);
		ubicaciones.add(3);
		ubicaciones.add(4);
		ubicaciones.add(5);
		ubicaciones.add(6);
		ubicaciones.add(7);
		ubicaciones.add(8);

		return ubicaciones;
	}

	public static ArrayList<Perfume> buildRandomCombination() {
		NombresEnum[] vNombres = NombresEnum.values();
		ArrayList<NombresEnum> nombres = new ArrayList<NombresEnum>(Arrays.asList(vNombres));
		
		AromasEnum[] vAromas = AromasEnum.values();
		ArrayList<AromasEnum> aromas = new ArrayList<AromasEnum>(Arrays.asList(vAromas));
		
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
