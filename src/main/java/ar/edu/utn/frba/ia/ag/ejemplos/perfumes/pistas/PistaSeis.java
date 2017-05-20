
package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaSeis extends Pista {

	/****
		El Tommy Girl está entre un perfume cítrico y uno floral. (2 Puntos)
	****/


	public PistaSeis(ArrayList<Perfume> perfumes) {
		super(perfumes);
		puntuacion = 10;
	}

	@Override
	public Boolean condicion() {
		Perfume perfumeTommy = searchPerfumeByName(NombresEnum.TOMMY);
		Perfume perfumeCitrico = searchPerfumeBySmell(AromasEnum.CITRICO);
		Perfume perfumeFloral = searchPerfumeBySmell(AromasEnum.FLORAL);
		
		return ( perfumeTommy.getUbicacion() == perfumeCitrico.getUbicacion() - 1 && perfumeTommy.getUbicacion() == perfumeFloral.getUbicacion() + 1)
				|| ( perfumeTommy.getUbicacion() == perfumeCitrico.getUbicacion() + 1 && perfumeTommy.getUbicacion() == perfumeFloral.getUbicacion() - 1);
		
	}

	@Override
	public void penalizar() {
		Perfume perfumeTommy = searchPerfumeByName(NombresEnum.TOMMY);
		Perfume perfumeCitrico = searchPerfumeBySmell(AromasEnum.CITRICO);
		Perfume perfumeFloral = searchPerfumeBySmell(AromasEnum.FLORAL);
		
		Boolean primerDesbordamiento = (perfumeCitrico.getUbicacion() - 1 < 1) && (perfumeFloral.getUbicacion() + 1 > 8);
		Boolean segundoDesbordamiento = (perfumeCitrico.getUbicacion() + 1 > 8) && (perfumeFloral.getUbicacion() - 1 < 1);
		
		if(primerDesbordamiento && segundoDesbordamiento){
			penalizacion += 4;
		}
		if(perfumeTommy.getUbicacion() == 1 || perfumeTommy.getUbicacion() == 8){
			penalizacion += 1;
		}
		
	}
} 