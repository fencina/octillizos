package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.CombinacionPerfumes;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public abstract class Pista {

	public Integer puntuacion;
	public Integer verdad;
	public Integer penalizacion;
	public CombinacionPerfumes combinacion;

	public ArrayList<Perfume> perfumes;
	
	public Pista(CombinacionPerfumes combinacion) {
		this.verdad = 0;
		this.penalizacion = 0;
		this.combinacion = combinacion;
		this.perfumes = combinacion.getPerfumes();
	}

	public Double resolver() {
		
		if(this.condicion()) {		
			verdad = 1;
		} else{
			//this.penalizar();
		}
		
		return (double) ((puntuacion * verdad) - penalizacion);
	};
	
	public abstract Boolean condicion();
	public abstract void  penalizar();
	
	public Perfume searchPerfumeByName(NombresEnum nombre) {

		Perfume foundPerfume = new Perfume();
		
		for (Perfume perfume : perfumes) {
			if (perfume.getNombre() == nombre) {
				foundPerfume = perfume;
				break;
			}
		}

		return foundPerfume;
	}

	public Perfume searchPerfumeBySmell(AromasEnum aroma) {

		Perfume foundPerfume = new Perfume();

		for (Perfume perfume : perfumes) {
			if (perfume.getAroma() == aroma) {
				foundPerfume = perfume;
				break;
			}
		}

		return foundPerfume;
	}

	public Perfume searchPerfumeByLocation(Integer ubicacion) {
		
		Perfume foundPerfume = new Perfume();

		for (Perfume perfume : perfumes) {
			if (this.getUbicacion(perfume) == ubicacion) {
				foundPerfume = perfume;
				break;
			}
		}

		return foundPerfume;
	}
	
	public int getUbicacion(Perfume perfume){
		return this.combinacion.getUbicacion(perfume);
	}
} 