
package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.CombinacionPerfumes;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaNueve extends Pista {

	/****
		Un Antonio Banderas es el segundo perfume a la izquierda de un Carolina Herrera. (1 Punto)
	****/


	public PistaNueve(CombinacionPerfumes combinacion) {		
		super(combinacion);
		puntuacion = 5;
	}

	@Override
	public Boolean condicion() {
		Perfume perfumeBanderas = searchPerfumeByName(NombresEnum.BANDERAS);
		Perfume perfumeCH = searchPerfumeByName(NombresEnum.CH);
		
		return getUbicacion(perfumeBanderas) == getUbicacion(perfumeCH) - 2;
	}

	@Override
	public void penalizar() {
		Perfume perfumeBanderas = searchPerfumeByName(NombresEnum.BANDERAS);
		Perfume perfumeCH = searchPerfumeByName(NombresEnum.CH);
		
		if(getUbicacion(perfumeCH) - 2 < 1){
			penalizacion += 2;
		}
		if(getUbicacion(perfumeBanderas) + 2 > 8){
			penalizacion += 2;
		}
	}
} 