
package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

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

		Perfume perfumePolo = searchPerfumeByName(NombresEnum.POLO);
		Perfume perfumeOceanico = searchPerfumeBySmell(AromasEnum.OCEANICO);
		Perfume perfumeEspeciado = searchPerfumeBySmell(AromasEnum.ESPECIADO);

		if ( perfumePolo.getUbicacion() == perfumeOceanico.getUbicacion() + 2 &&
			 perfumePolo.getUbicacion() == perfumeEspeciado.getUbicacion() - 2 ) {
			verdad = 1;
		}

		return (double) (puntuacion * verdad);
	}
} 