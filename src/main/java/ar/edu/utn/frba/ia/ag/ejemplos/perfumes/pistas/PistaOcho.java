
package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;
import java.util.ArrayList;
import java.util.logging.Logger;

public class PistaOcho extends Pista {

	/****
		El Polo es el segundo perfume a la derecha del perfume con aroma oceánico 
		y el segundo a la izquierda con aroma especiado. (1 Punto)
	****/

	public Integer puntuacion = 1;

	public PistaOcho(ArrayList<Perfume> perfumes) {
		
		super(perfumes);
	}

	public Double resolver() {

		Perfume perfumePolo = searchPerfumeByName("Polo");
		Perfume perfumeOceanico = searchPerfumeBySmell("oceanico");
		Perfume perfumeEspeciado = searchPerfumeBySmell("especiado");

		if ( perfumePolo.getUbicacion() == perfumeOceanico.getUbicacion() + 2 &&
			 perfumePolo.getUbicacion() == perfumeEspeciado.getUbicacion() - 2 ) {
			verdad = 1;
		}

		return (double) (puntuacion * verdad);
	}
} 