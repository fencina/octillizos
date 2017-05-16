
package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaNueve extends Pista {

	/****
		Un Antonio Banderas es el segundo perfume a la izquierda de un Carolina Herrera. (1 Punto)
	****/

	public Integer puntuacion = 1;

	public PistaNueve(ArrayList<Perfume> perfumes) {
		
		super(perfumes);
	}

	public Double resolver() {

		Perfume perfumeBanderas = searchPerfumeByName(NombresEnum.BANDERAS);
		Perfume perfumeCH = searchPerfumeByName(NombresEnum.CH);

		if ( perfumeBanderas.getUbicacion() == perfumeCH.getUbicacion() - 2 ) {
			verdad = 1;
		}

		return (double) (puntuacion * verdad);
	}
} 