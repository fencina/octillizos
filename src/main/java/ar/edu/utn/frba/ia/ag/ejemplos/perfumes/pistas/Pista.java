package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.AromasEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.NombresEnum;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;

public abstract class Pista {

	public Integer puntuacion;
	public Integer verdad = 0;

	public ArrayList<Perfume> perfumes;
	
	public Pista(ArrayList<Perfume> perfumes) {
		
		this.perfumes = perfumes;
	}

	public abstract Double resolver();

//	public Perfume searchPerfumeByName(String nombre) {
//
//		Perfume foundPerfume = new Perfume();
//
//		for (Perfume perfume : perfumes) {
//			if (perfume.getNombre() == nombre) {
//				foundPerfume = perfume;
//				break;
//			}
//		}
//
//		return foundPerfume;
//	}
	
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
			if (perfume.getUbicacion() == ubicacion) {
				foundPerfume = perfume;
				break;
			}
		}

		return foundPerfume;
	}
} 