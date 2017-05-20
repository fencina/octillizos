package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

import java.util.ArrayList;
import java.util.Collections;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes.pistas.*;

public class CombinacionPerfumes extends Individuo {
	
	//private ArrayList<Perfume> perfumes;
	private Perfume posicion1;
	private Perfume posicion2;
	private Perfume posicion3;
	private Perfume posicion4;
	private Perfume posicion5;
	private Perfume posicion6;
	private Perfume posicion7;
	private Perfume posicion8;

	@Override
	public Individuo generarRandom() {
		
		//CombinacionPerfumes combinacion = new CombinacionPerfumes();

		//combinacion.setPerfumes(PerfumeUtils.buildRandomCombination());

		
		return PerfumeUtils.buildRandomCombination();
	}
	
	@Override
	public double aptitud() {

		double valorAptitud = 0;

		ArrayList<Pista> pistas = getPistas();

		for (Pista pista : pistas ) {
			valorAptitud += pista.resolver();
		}

		return valorAptitud;
	}

    public ArrayList<Pista> getPistas() {

       ArrayList<Pista> pistas = new ArrayList<Pista>();

       pistas.add(new PistaUno(this));
       pistas.add(new PistaDos(this));
       pistas.add(new PistaTres(this));
       pistas.add(new PistaCuatro(this));
       pistas.add(new PistaCinco(this));
       pistas.add(new PistaSeis(this));
       pistas.add(new PistaSiete(this));
       pistas.add(new PistaOcho(this));
       pistas.add(new PistaNueve(this));

       return pistas;
    }


//	public ArrayList<Perfume> getPerfumes() {
//		return perfumes;
//	}
    
	public ArrayList<Perfume> getPerfumes() {
		ArrayList<Perfume> perfumes = new ArrayList<Perfume>();
		perfumes.add(this.posicion1);
		perfumes.add(this.posicion2);
		perfumes.add(this.posicion3);
		perfumes.add(this.posicion4);
		perfumes.add(this.posicion5);
		perfumes.add(this.posicion6);
		perfumes.add(this.posicion7);
		perfumes.add(this.posicion8);
		return perfumes;
}
	
//	public void setPerfumes(ArrayList<Perfume> perfumes) {
//		this.perfumes = perfumes;
//	}
	
	@Override
	public String toString() {

		String mensaje = "\nUbicación;Perfume;Aroma;\n";

		ArrayList<Perfume> perfumes = this.getPerfumes();

		for (Perfume perfume : perfumes ) {
			mensaje += getUbicacion(perfume);
			mensaje += ";" + perfume.getNombre().getString();
			mensaje += ";" + perfume.getAroma().getString() + ";\n";
		}

		return mensaje;
	}

	public Perfume getPosicion1() {
		return posicion1;
	}

	public void setPosicion1(Perfume posicion1) {
		this.posicion1 = posicion1;
	}

	public Perfume getPosicion2() {
		return posicion2;
	}

	public void setPosicion2(Perfume posicion2) {
		this.posicion2 = posicion2;
	}

	public Perfume getPosicion3() {
		return posicion3;
	}

	public void setPosicion3(Perfume posicion3) {
		this.posicion3 = posicion3;
	}

	public Perfume getPosicion4() {
		return posicion4;
	}

	public void setPosicion4(Perfume posicion4) {
		this.posicion4 = posicion4;
	}

	public Perfume getPosicion5() {
		return posicion5;
	}

	public void setPosicion5(Perfume posicion5) {
		this.posicion5 = posicion5;
	}

	public Perfume getPosicion6() {
		return posicion6;
	}

	public void setPosicion6(Perfume posicion6) {
		this.posicion6 = posicion6;
	}

	public Perfume getPosicion7() {
		return posicion7;
	}

	public void setPosicion7(Perfume posicion7) {
		this.posicion7 = posicion7;
	}

	public Perfume getPosicion8() {
		return posicion8;
	}

	public void setPosicion8(Perfume posicion8) {
		this.posicion8 = posicion8;
	}
	
	public int getUbicacion(Perfume perfume){
		if(perfume == this.posicion1)
			return 1;
		if(perfume == this.posicion2)
			return 2;
		if(perfume == this.posicion3)
			return 3;
		if(perfume == this.posicion4)
			return 4;
		if(perfume == this.posicion5)
			return 5;
		if(perfume == this.posicion6)
			return 6;
		if(perfume == this.posicion7)
			return 7;
		if(perfume == this.posicion8)
			return 8;
		return 0;
	}
}
