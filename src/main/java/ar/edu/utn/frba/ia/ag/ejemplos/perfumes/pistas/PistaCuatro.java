package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.CombinacionPerfumes;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaCuatro extends Pista {

	/****
		El Paco Rabanne no tiene ningún perfume a su izquierda
		y está a la izquierda del perfume acaramelado. (2 Puntos)
	****/


	public PistaCuatro(CombinacionPerfumes combinacion) {	
		super(combinacion);
		puntuacion = 7;
	}

	@Override
	public Boolean condicion() {
		Perfume perfumePR = searchPerfumeByName(NombresEnum.PR);
		Perfume perfumeAcaramelado = searchPerfumeBySmell(AromasEnum.ACARAMELADO);
		
		return ( getUbicacion(perfumePR) == 1 && getUbicacion(perfumePR) == getUbicacion(perfumeAcaramelado) - 1 );
	}

	@Override
	public void penalizar() {
		Perfume perfumePR = searchPerfumeByName(NombresEnum.PR);
		Perfume perfumeAcaramelado = searchPerfumeBySmell(AromasEnum.ACARAMELADO);
		
		if(getUbicacion(perfumeAcaramelado) - 1 < 1){
			penalizacion += 1;
		}
		if(getUbicacion(perfumePR) + 1 > 8){
			penalizacion += 1;
		}
	}
} 