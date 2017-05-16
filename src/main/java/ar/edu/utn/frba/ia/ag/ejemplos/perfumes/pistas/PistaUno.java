package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaUno extends Pista {

	/****
		El Dolce & Gabbana es el segundo perfume a la izquierda del Tommy Girl
		y el primero a la derecha del perfume frutal. (2 Puntos)
	****/

	public Integer puntuacion = 2;

	public PistaUno(ArrayList<Perfume> perfumes) {
		
		super(perfumes);
	}

	public Double resolver() {

		Perfume perfumeDG = searchPerfumeByName(NombresEnum.DANDG);
		Perfume perfumeTommy = searchPerfumeByName(NombresEnum.TOMMY);
		Perfume perfumeFrutal = searchPerfumeBySmell("frutal");

		if (perfumeDG.getUbicacion() == perfumeTommy.getUbicacion() - 2 &&
			perfumeDG.getUbicacion() == perfumeFrutal.getUbicacion() + 1) {
			verdad = 1;
		}

		return (double) (puntuacion * verdad);
	}
} 