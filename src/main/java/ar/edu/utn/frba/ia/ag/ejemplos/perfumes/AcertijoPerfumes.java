package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialMascaraComplemento;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionSimple;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.ControlSobreNumeroEsperado;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;

public class AcertijoPerfumes {
	
	public static void main(String[] args) {
		
		ConfiguracionDefault config = new ConfiguracionDefault();
		//config.setCriterioDeParo(new CantidadDeCiclos(1L));
		//config.setPoblacionInicial(1);
		
//		new CantidadDeCiclos(99L), // criterio de paro
//		999, // cantIndividuosIniciales
//		new Torneo(), // seleccion
//		new Simple(), // cruzamiento
//		new MutacionSimple(0.2)
		
		AlgoritmoGenetico combinacionPerfumes = new AlgoritmoGenetico(config, CombinacionPerfumes.class);
		
		Individuo combinacion = combinacionPerfumes.ejecutar();
		
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + combinacion.toString());
		
		System.out.println("------------------------------------------------------------------------");
		
	}
	
}

