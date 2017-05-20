
package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.CombinacionPerfumes;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaSiete extends Pista {

	/****
		El perfume floral está a la izquierda del perfume Polo.  (1 Punto)
	****/


	public PistaSiete(CombinacionPerfumes combinacion) {		
		super(combinacion);
		puntuacion = 5;
	}

	@Override
	public Boolean condicion() {
		Perfume perfumeFloral = searchPerfumeBySmell(AromasEnum.FLORAL);
		Perfume perfumePolo = searchPerfumeByName(NombresEnum.POLO);
		
		return getUbicacion(perfumeFloral) == getUbicacion(perfumePolo) - 1;
	}

	@Override
	public void penalizar() {
		Perfume perfumeFloral = searchPerfumeBySmell(AromasEnum.FLORAL);
		Perfume perfumePolo = searchPerfumeByName(NombresEnum.POLO);
		
		if(getUbicacion(perfumePolo) - 1  < 1){
			penalizacion += 1;
		}
		if(getUbicacion(perfumeFloral) + 1 > 8){
			penalizacion += 1;
		}
	}
} 