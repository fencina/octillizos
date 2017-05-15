
package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;
import java.util.ArrayList;
import java.util.logging.Logger;

public class PistaSiete extends Pista {

	/****
		El perfume floral está a la izquierda del perfume Polo.  (1 Punto)
	****/

	public Integer puntuacion = 1;

	public PistaSiete(ArrayList<Perfume> perfumes) {
		
		super(perfumes);
	}

	public Double resolver() {

		Perfume perfumeFloral = searchPerfumeBySmell("floral");
		Perfume perfumePolo = searchPerfumeByName("Polo");

		if ( perfumeFloral.getUbicacion() == perfumePolo.getUbicacion() - 1) {
			verdad = 1;
		}

		return (double) (puntuacion * verdad);
	}
} 