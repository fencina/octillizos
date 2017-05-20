package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.CombinacionPerfumes;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaUno extends Pista {

	/****
		El Dolce & Gabbana es el segundo perfume a la izquierda del Tommy Girl
		y el primero a la derecha del perfume frutal. (2 Puntos)
	****/


	public PistaUno(CombinacionPerfumes combinacion) {		
		super(combinacion);
		puntuacion = 15;
	}
	
	@Override
	public Boolean condicion(){
		Perfume perfumeDG = searchPerfumeByName(NombresEnum.DANDG);
		Perfume perfumeTommy = searchPerfumeByName(NombresEnum.TOMMY);
		Perfume perfumeFrutal = searchPerfumeBySmell(AromasEnum.FRUTAL);

		return (
				getUbicacion(perfumeDG) == getUbicacion(perfumeTommy) - 2 &&
				getUbicacion(perfumeDG) == getUbicacion(perfumeFrutal) + 1);
	}

	@Override
	public void penalizar() {
		Perfume perfumeDG = searchPerfumeByName(NombresEnum.DANDG);
		Perfume perfumeTommy = searchPerfumeByName(NombresEnum.TOMMY);
		Perfume perfumeFrutal = searchPerfumeBySmell(AromasEnum.FRUTAL);
		
		if(getUbicacion(perfumeTommy) - 2 < 1){
			penalizacion += 2;
		}
		if(getUbicacion(perfumeDG) + 2 > 8){
			penalizacion += 2;
		}
		
		if(getUbicacion(perfumeFrutal) + 1 > 8){
			penalizacion += 1;
		}
		if(getUbicacion(perfumeDG) - 1 < 1){
			penalizacion += 1;
		}
	}
} 