package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaCinco extends Pista {

	/****
		A la derecha del perfume acaramelado está un Chanel. (1 Punto)
	****/


	public PistaCinco(ArrayList<Perfume> perfumes) {
		super(perfumes);
		puntuacion = 5;
	}

	@Override
	public Boolean condicion() {
		Perfume perfumeChanel = searchPerfumeByName(NombresEnum.CHANEL);
		Perfume perfumeAcaramelado = searchPerfumeBySmell(AromasEnum.ACARAMELADO);
		return perfumeChanel.getUbicacion() == perfumeAcaramelado.getUbicacion() + 1;
	}

	@Override
	public void penalizar() {
		Perfume perfumeChanel = searchPerfumeByName(NombresEnum.CHANEL);
		Perfume perfumeAcaramelado = searchPerfumeBySmell(AromasEnum.ACARAMELADO);
		
		if(perfumeChanel.getUbicacion() - 1 < 1){
			penalizacion += 1;
		}
		if(perfumeAcaramelado.getUbicacion() + 1 < 8){
			penalizacion += 1;
		}
	}
	
} 