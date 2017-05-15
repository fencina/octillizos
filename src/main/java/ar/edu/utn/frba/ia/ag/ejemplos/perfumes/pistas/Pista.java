package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas;

import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.Perfume;
import java.util.ArrayList;
import java.util.logging.Logger;

public abstract class Pista {

	public Integer puntuacion;
	public Integer verdad = 0;

	public ArrayList<Perfume> perfumes;
	
	public Pista(ArrayList<Perfume> perfumes) {
		
		this.perfumes = perfumes;
	}

	public abstract Double resolver();

	public Perfume searchPerfumeByName(String nombre) {

		Perfume foundPerfume = new Perfume();

		for (Perfume perfume : perfumes) {
			if (perfume.getNombre() == nombre) {
				foundPerfume = perfume;
				break;
			}
		}

		return foundPerfume;
	}

	public Perfume searchPerfumeBySmell(String aroma) {

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