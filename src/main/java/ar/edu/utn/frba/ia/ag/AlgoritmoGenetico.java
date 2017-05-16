package main.java.ar.edu.utn.frba.ia.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlgoritmoGenetico {
	
	private Configuracion configuracion;
	private List<Individuo> individuos;
	private Class<? extends Individuo> individuoClass;
	private Estado estado = new Estado();
	
	protected void agregarIndividuo(Individuo individuo) {
		
		if (this.individuos == null) {
			this.individuos = new ArrayList<Individuo>();
		}
		
		this.individuos.add(individuo);
	}
	
	public AlgoritmoGenetico(Configuracion configuracion, Class<? extends Individuo> individuoClass) {
		
		this.configuracion = (configuracion != null ? configuracion : new ConfiguracionDefault());
		this.individuoClass = individuoClass;
	}
	
	protected void generarPoblacionInicial(Class<? extends Individuo> individuoClass) {
		
		for (int i = 0; i < this.configuracion.getPoblacionInicial(); i++) {
			try {
				this.agregarIndividuo(individuoClass.newInstance().generarRandom());
			} catch (Exception e) {
				Logger.getLogger(
					Logger.GLOBAL_LOGGER_NAME).severe(
						"No se puede crear una instancia de "
						+ individuoClass.getName()
						+ ". Probablemente no tenga un constructor vacio."
						+ " // CAUSA: " + e);
			}
		}
	}
	
	public Individuo ejecutar() {
		
		this.generarPoblacionInicial(individuoClass);
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.FINE, "PoblaciÃ³n inicial");
		
		for (Individuo individuo : this.individuos) {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.FINE, individuo.toString());
		}
		
		Integer iteracion = new Integer(0);
		
		while (!this.configuracion.getCriterioDeParo().parar(this.individuos)) {
			
			this.estadisticas(iteracion);
			
			this.seleccion();
			
			this.cruzamiento();
			
			this.mutacion();
			
			iteracion++;
		}
		
		Collections.sort(this.individuos);
		
		this.loggearEstado();
		
		return this.individuos.get(0);
	}
	
	private void estadisticas(Integer iteracion) {
		
		Double totalAptitudes = new Double(0);
		Individuo mejorIndividuo = this.individuos.get(0);
		Individuo peorIndividuo = this.individuos.get(0);
		
		for (int i = 0; i < this.individuos.size(); i++) {
			
			Individuo individuo = this.individuos.get(i);
			
			totalAptitudes += individuo.aptitud();
			
			if (individuo.esMasAptoQue(mejorIndividuo)) {
				mejorIndividuo = individuo;
			}
			else if ( ! individuo.esMasAptoQue(peorIndividuo)) {
				peorIndividuo = individuo;
			}
			
		}
		
		this.estado.agregarTotalAptitudes(totalAptitudes);
		this.estado.agregarAptitudesPromedio(totalAptitudes / this.individuos.size());
		this.estado.agregarMejorIndividuo(mejorIndividuo);
		this.estado.agregarPeorIndividuo(peorIndividuo);
		this.estado.setCiclos(iteracion);
	}
	
	private void seleccion() {
		this.individuos = this.configuracion.getMetodoDeSeleccion().seleccionar(this.individuos, this.estado);
		
	}
	
	private void cruzamiento() {
		this.configuracion.getCruzamiento().cruzarIndividuos(this.individuos);
	}
	
	private void mutacion() {
		this.configuracion.getMutacion().mutar(this.individuos, this.estado);
	}
	
    private void loggearEstado() {
		System.out.print("Individuo final: " + this.individuos.get(0).toString());
		System.out.println("Cantidad de Veces que muto: " + this.estado.getCantMutaciones() + " / " + this.estado.getCiclos() + "\n");
		System.out.println("Individuo Campeon: " + this.estado.getMejorIndividuo());
		System.out.println("Peor Individuo: " + this.estado.getPeorIndividuo());
		
		System.out.println("Funciones de aptitud por iteración:");
		System.out.println("Iteración;Mejor;Promedio;Peor");
		for (int i = 0; i < this.estado.getMejoresIndividuos().size(); i++) {
			
			Individuo mejorIndividuo = this.estado.getMejoresIndividuos().get(i);
			Individuo peorIndividuo = this.estado.getPeoresIndividuos().get(i);
			Double aptitudPromedio = this.estado.getAptitudesPromedio().get(i);
			
			System.out.print(String.format("%d;", i));
			System.out.print(String.format("%1$.3f;", mejorIndividuo.aptitud()));
			System.out.print(String.format("%1$.3f;", aptitudPromedio));
			System.out.println(String.format("%1$.3f;", peorIndividuo.aptitud()));
		}
	}
}
