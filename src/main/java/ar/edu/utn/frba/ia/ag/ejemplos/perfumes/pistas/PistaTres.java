package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaTres extends Pista {

	/****
		El perfume oriental está entre el Calvin Klein y el perfume amaderado. (2 Puntos)
	****/


	public PistaTres(ArrayList<Perfume> perfumes) {
		super(perfumes);
		puntuacion = 7;
	}

	@Override
	public Boolean condicion() {
		Perfume perfumeOriental = searchPerfumeBySmell(AromasEnum.ORIENTAL);
		Perfume perfumeAmaderado = searchPerfumeBySmell(AromasEnum.AMADERADO);
		Perfume perfumeCK = searchPerfumeByName(NombresEnum.CK);
		
		return (
			( perfumeOriental.getUbicacion() == perfumeAmaderado.getUbicacion() - 1 && perfumeOriental.getUbicacion() == perfumeCK.getUbicacion() + 1)
			|| ( perfumeOriental.getUbicacion() == perfumeAmaderado.getUbicacion() + 1 && perfumeOriental.getUbicacion() == perfumeCK.getUbicacion() - 1));
	}

	@Override
	public void penalizar() {
		Perfume perfumeOriental = searchPerfumeBySmell(AromasEnum.ORIENTAL);
		Perfume perfumeAmaderado = searchPerfumeBySmell(AromasEnum.AMADERADO);
		Perfume perfumeCK = searchPerfumeByName(NombresEnum.CK);
		
		Boolean primerDesbordamiento = (perfumeAmaderado.getUbicacion() - 1 < 1) && (perfumeCK.getUbicacion() + 1 > 8);
		Boolean segundoDesbordamiento = (perfumeAmaderado.getUbicacion() + 1 > 8) && (perfumeCK.getUbicacion() - 1 < 1);
		
		if(primerDesbordamiento && segundoDesbordamiento){
			penalizacion += 4;
		}
		if(perfumeOriental.getUbicacion() == 1 || perfumeOriental.getUbicacion() == 8){
			penalizacion += 1;
		}
	}
} 