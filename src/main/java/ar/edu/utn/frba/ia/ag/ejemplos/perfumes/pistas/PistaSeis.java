
package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;
import java.util.ArrayList;
import java.util.logging.Logger;

public class PistaSeis extends Pista {

	/****
		El Tommy Girl está entre un perfume cítrico y uno floral. (2 Puntos)
	****/

	public Integer puntuacion = 2;

	public PistaSeis(ArrayList<Perfume> perfumes) {
		
		super(perfumes);
	}

	public Double resolver() {

		Perfume perfumeTommy = searchPerfumeByName("Tommy");
		Perfume perfumeCitrico = searchPerfumeBySmell("citrico");
		Perfume perfumeFloral = searchPerfumeBySmell("floral");

		if ( ( perfumeTommy.getUbicacion() == perfumeCitrico.getUbicacion() - 1 && perfumeTommy.getUbicacion() == perfumeFloral.getUbicacion() + 1)
			|| ( perfumeTommy.getUbicacion() == perfumeCitrico.getUbicacion() + 1 && perfumeTommy.getUbicacion() == perfumeFloral.getUbicacion() - 1)) {
			verdad = 1;
		}

		return (double) (puntuacion * verdad);
	}
} 