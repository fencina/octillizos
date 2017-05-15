
package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;
import java.util.ArrayList;
import java.util.logging.Logger;

public class PistaNueve extends Pista {

	/****
		Un Antonio Banderas es el segundo perfume a la izquierda de un Carolina Herrera. (1 Punto)
	****/

	public Integer puntuacion = 1;

	public PistaNueve(ArrayList<Perfume> perfumes) {
		
		super(perfumes);
	}

	public Double resolver() {

		Perfume perfumeBanderas = searchPerfumeByName("Banderas");
		Perfume perfumeCH = searchPerfumeByName("CH");

		if ( perfumeBanderas.getUbicacion() == perfumeCH.getUbicacion() - 2 ) {
			verdad = 1;
		}

		return (double) (puntuacion * verdad);
	}
} 