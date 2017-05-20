package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.CombinacionPerfumes;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaDos extends Pista {

	/****
		El Calvin Klein no tiene perfume a su derecha 
		y está después del perfume oriental. (2 Puntos)
	****/


	public PistaDos(CombinacionPerfumes combinacion) {
		super(combinacion);
		puntuacion = 7;
	}

	@Override
	public Boolean condicion() {
		Perfume perfumeCK = searchPerfumeByName(NombresEnum.CK);
		Perfume perfumeOriental = searchPerfumeBySmell(AromasEnum.ORIENTAL);

		return (
			getUbicacion(perfumeCK) == 8 &&
			getUbicacion(perfumeOriental) == getUbicacion(perfumeCK) - 1);
	}

	@Override
	public void penalizar() {
		Perfume perfumeCK = searchPerfumeByName(NombresEnum.CK);
		Perfume perfumeOriental = searchPerfumeBySmell(AromasEnum.ORIENTAL);
		
		if(getUbicacion(perfumeCK) - 1 < 1){
			penalizacion += 1;
		}
		if(getUbicacion(perfumeOriental) + 1 > 8){
			penalizacion += 1;
		}
	}
} 