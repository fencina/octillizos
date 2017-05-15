package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;
import java.util.ArrayList;
import java.util.logging.Logger;

public class PistaCinco extends Pista {

	/****
		A la derecha del perfume acaramelado está un Chanel. (1 Punto)
	****/

	public Integer puntuacion = 1;

	public PistaCinco(ArrayList<Perfume> perfumes) {
		
		super(perfumes);
	}

	public Double resolver() {

		Perfume perfumeChanel = searchPerfumeByName("Chanel");
		Perfume perfumeAcaramelado = searchPerfumeBySmell("acaramelado");

		if ( perfumeChanel.getUbicacion() == perfumeAcaramelado.getUbicacion() + 1 ) {
			verdad = 1;
		}

		return (double) (puntuacion * verdad);
	}
} 