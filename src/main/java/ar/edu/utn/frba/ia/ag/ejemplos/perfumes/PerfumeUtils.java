package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

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

	public static Individuo buildRandomCombination() {
		NombresEnum[] vNombres = NombresEnum.values();
		ArrayList<NombresEnum> nombres = new ArrayList<NombresEnum>(Arrays.asList(vNombres));
		
		AromasEnum[] vAromas = AromasEnum.values();
		ArrayList<AromasEnum> aromas = new ArrayList<AromasEnum>(Arrays.asList(vAromas));
		
		ArrayList<Integer> ubicaciones = PerfumeUtils.buildLocationsArray();

		CombinacionPerfumes combinacion = new CombinacionPerfumes();
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
			//perfume.setUbicacion(ubicaciones.get(randomIndex));
			int ubicacionRnd = ubicaciones.get(randomIndex);
			ubicaciones.remove(randomIndex);

			//combinacion.add(perfume);
//			System.out.println(String.format("i: %d;", i));
//			System.out.println(String.format("ubicacion: %d;", ubicacionRnd));
			switch(ubicacionRnd){
				case 1:
					combinacion.setPosicion1(perfume);
					break;
				case 2:
					combinacion.setPosicion2(perfume);
					break;
				case 3:
					combinacion.setPosicion3(perfume);
					break;
				case 4:
					combinacion.setPosicion4(perfume);
					break;
				case 5:
					combinacion.setPosicion5(perfume);
					break;
				case 6:
					combinacion.setPosicion6(perfume);
					break;
				case 7:
					combinacion.setPosicion7(perfume);
					break;
				case 8:
					combinacion.setPosicion8(perfume);
					break;
			}
		}

		return combinacion;
	}

}
