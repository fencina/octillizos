package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;
import java.util.ArrayList;
import java.util.logging.Logger;

public class PistaDos extends Pista {

	/****
		El Calvin Klein no tiene perfume a su derecha 
		y está después del perfume oriental. (2 Puntos)
	****/

	public Integer puntuacion = 2;

	public PistaDos(ArrayList<Perfume> perfumes) {
		
		super(perfumes);
	}

	public Double resolver() {

		Perfume perfumeCK = searchPerfumeByName("CK");
		Perfume perfumeOriental = searchPerfumeBySmell("oriental");

		if (perfumeCK.getUbicacion() == 8 &&
			perfumeCK.getUbicacion() == perfumeOriental.getUbicacion() + 1) {
			verdad = 1;
		}

		return (double) (puntuacion * verdad);
	}
} 