package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaCinco extends Pista {

	/****
		A la derecha del perfume acaramelado está un Chanel. (1 Punto)
	****/

	public Integer puntuacion = 1;

	public PistaCinco(ArrayList<Perfume> perfumes) {
		
		super(perfumes);
	}

	public Double resolver() {

		Perfume perfumeChanel = searchPerfumeByName(NombresEnum.CHANEL);
		Perfume perfumeAcaramelado = searchPerfumeBySmell("acaramelado");

		if ( perfumeChanel.getUbicacion() == perfumeAcaramelado.getUbicacion() + 1 ) {
			verdad = 1;
		}

		return (double) (puntuacion * verdad);
	}
} 