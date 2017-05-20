package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaDos extends Pista {

	/****
		El Calvin Klein no tiene perfume a su derecha 
		y está después del perfume oriental. (2 Puntos)
	****/


	public PistaDos(ArrayList<Perfume> perfumes) {
		super(perfumes);
		puntuacion = 7;
	}

	@Override
	public Boolean condicion() {
		Perfume perfumeCK = searchPerfumeByName(NombresEnum.CK);
		Perfume perfumeOriental = searchPerfumeBySmell(AromasEnum.ORIENTAL);

		return (
			perfumeCK.getUbicacion() == 8 &&
			perfumeOriental.getUbicacion() == perfumeCK.getUbicacion() - 1);
	}

	@Override
	public void penalizar() {
		Perfume perfumeCK = searchPerfumeByName(NombresEnum.CK);
		Perfume perfumeOriental = searchPerfumeBySmell(AromasEnum.ORIENTAL);
		
		if(perfumeCK.getUbicacion() - 1 < 1){
			penalizacion += 1;
		}
		if(perfumeOriental.getUbicacion() + 1 > 8){
			penalizacion += 1;
		}
	}
} 