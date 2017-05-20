package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.CombinacionPerfumes;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaTres extends Pista {

	/****
		El perfume oriental está entre el Calvin Klein y el perfume amaderado. (2 Puntos)
	****/


	public PistaTres(CombinacionPerfumes combinacion) {
		super(combinacion);
		puntuacion = 7;
	}

	@Override
	public Boolean condicion() {
		Perfume perfumeOriental = searchPerfumeBySmell(AromasEnum.ORIENTAL);
		Perfume perfumeAmaderado = searchPerfumeBySmell(AromasEnum.AMADERADO);
		Perfume perfumeCK = searchPerfumeByName(NombresEnum.CK);
		
		return (
			( getUbicacion(perfumeOriental) == getUbicacion(perfumeAmaderado) - 1 && getUbicacion(perfumeOriental) == getUbicacion(perfumeCK) + 1)
			|| ( getUbicacion(perfumeOriental) == getUbicacion(perfumeAmaderado) + 1 && getUbicacion(perfumeOriental) == getUbicacion(perfumeCK) - 1));
	}

	@Override
	public void penalizar() {
		Perfume perfumeOriental = searchPerfumeBySmell(AromasEnum.ORIENTAL);
		Perfume perfumeAmaderado = searchPerfumeBySmell(AromasEnum.AMADERADO);
		Perfume perfumeCK = searchPerfumeByName(NombresEnum.CK);
		
		Boolean primerDesbordamiento = (getUbicacion(perfumeAmaderado) - 1 < 1) && (getUbicacion(perfumeCK) + 1 > 8);
		Boolean segundoDesbordamiento = (getUbicacion(perfumeAmaderado) + 1 > 8) && (getUbicacion(perfumeCK) - 1 < 1);
		
		if(primerDesbordamiento && segundoDesbordamiento){
			penalizacion += 4;
		}
		if(getUbicacion(perfumeOriental) == 1 || getUbicacion(perfumeOriental) == 8){
			penalizacion += 1;
		}
	}
} 