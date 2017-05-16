package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaCuatro extends Pista {

	/****
		El Paco Rabanne no tiene ningún perfume a su izquierda
		y está a la izquierda del perfume acaramelado. (2 Puntos)
	****/

	public Integer puntuacion = 2;

	public PistaCuatro(ArrayList<Perfume> perfumes) {
		
		super(perfumes);
	}

	public Double resolver() {

		Perfume perfumePR = searchPerfumeByName(NombresEnum.PR);
		Perfume perfumeAcaramelado = searchPerfumeBySmell(AromasEnum.ACARAMELADO);

		if ( perfumePR.getUbicacion() == 1 && perfumePR.getUbicacion() == perfumeAcaramelado.getUbicacion() -1 ) {
			verdad = 1;
		}

		return (double) (puntuacion * verdad);
	}
} 