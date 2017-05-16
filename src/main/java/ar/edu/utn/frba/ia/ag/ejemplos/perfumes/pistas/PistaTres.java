package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaTres extends Pista {

	/****
		El perfume oriental está entre el Calvin Klein y el perfume amaderado. (2 Puntos)
	****/

	public Integer puntuacion = 2;

	public PistaTres(ArrayList<Perfume> perfumes) {
		
		super(perfumes);
	}

	public Double resolver() {

		Perfume perfumeOriental = searchPerfumeBySmell(AromasEnum.ORIENTAL);
		Perfume perfumeAmaderado = searchPerfumeBySmell(AromasEnum.AMADERADO);
		Perfume perfumeCK = searchPerfumeByName(NombresEnum.CK);

		if ( ( perfumeOriental.getUbicacion() == perfumeAmaderado.getUbicacion() - 1 && perfumeOriental.getUbicacion() == perfumeCK.getUbicacion() + 1)
			|| ( perfumeOriental.getUbicacion() == perfumeAmaderado.getUbicacion() + 1 && perfumeOriental.getUbicacion() == perfumeCK.getUbicacion() - 1)) {
			verdad = 1;
		}

		return (double) (puntuacion * verdad);
	}
} 