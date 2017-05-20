
package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.CombinacionPerfumes;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaSeis extends Pista {

	/****
		El Tommy Girl está entre un perfume cítrico y uno floral. (2 Puntos)
	****/


	public PistaSeis(CombinacionPerfumes combinacion) {
		super(combinacion);
		puntuacion = 10;
	}

	@Override
	public Boolean condicion() {
		Perfume perfumeTommy = searchPerfumeByName(NombresEnum.TOMMY);
		Perfume perfumeCitrico = searchPerfumeBySmell(AromasEnum.CITRICO);
		Perfume perfumeFloral = searchPerfumeBySmell(AromasEnum.FLORAL);
		
		return ( getUbicacion(perfumeTommy) == getUbicacion(perfumeCitrico) - 1 && getUbicacion(perfumeTommy) == getUbicacion(perfumeFloral) + 1)
				|| ( getUbicacion(perfumeTommy) == getUbicacion(perfumeCitrico) + 1 && getUbicacion(perfumeTommy) == getUbicacion(perfumeFloral) - 1);
		
	}

	@Override
	public void penalizar() {
		Perfume perfumeTommy = searchPerfumeByName(NombresEnum.TOMMY);
		Perfume perfumeCitrico = searchPerfumeBySmell(AromasEnum.CITRICO);
		Perfume perfumeFloral = searchPerfumeBySmell(AromasEnum.FLORAL);
		
		Boolean primerDesbordamiento = (getUbicacion(perfumeCitrico) - 1 < 1) && (getUbicacion(perfumeFloral) + 1 > 8);
		Boolean segundoDesbordamiento = (getUbicacion(perfumeCitrico) + 1 > 8) && (getUbicacion(perfumeFloral) - 1 < 1);
		
		if(primerDesbordamiento && segundoDesbordamiento){
			penalizacion += 4;
		}
		if(getUbicacion(perfumeTommy) == 1 || getUbicacion(perfumeTommy) == 8){
			penalizacion += 1;
		}
		
	}
} 