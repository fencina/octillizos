
package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.CombinacionPerfumes;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public class PistaOcho extends Pista {

	/****
		El Polo es el segundo perfume a la derecha del perfume con aroma oceánico 
		y el segundo a la izquierda con aroma especiado. (1 Punto)
	****/


	public PistaOcho(CombinacionPerfumes combinacion) {		
		super(combinacion);
		puntuacion = 20;
	}

	@Override
	public Boolean condicion() {
		Perfume perfumePolo = searchPerfumeByName(NombresEnum.POLO);
		Perfume perfumeOceanico = searchPerfumeBySmell(AromasEnum.OCEANICO);
		Perfume perfumeEspeciado = searchPerfumeBySmell(AromasEnum.ESPECIADO);
		
		return 	getUbicacion(perfumePolo) == getUbicacion(perfumeOceanico) + 2 &&
				getUbicacion(perfumePolo) == getUbicacion(perfumeEspeciado) - 2;
	}

	@Override
	public void penalizar() {
		Perfume perfumePolo = searchPerfumeByName(NombresEnum.POLO);
		Perfume perfumeOceanico = searchPerfumeBySmell(AromasEnum.OCEANICO);
		Perfume perfumeEspeciado = searchPerfumeBySmell(AromasEnum.ESPECIADO);
		
		if(getUbicacion(perfumePolo) - 2 < 1){
			penalizacion += 2;
		}
		if(getUbicacion(perfumeOceanico) + 2 > 8){
			penalizacion += 2;
		}
		
		if(getUbicacion(perfumePolo) + 2 > 8){
			penalizacion += 2;
		}
		if(getUbicacion(perfumeEspeciado) - 2 < 1){
			penalizacion += 2;
		}
		
	}
} 