package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class BinomialAzarComplemento extends Cruzamiento {
	
	CruzamientoBinomialMascaraComplemento cruzamientoAuxiliarMascara;
	
	@Override
	protected void cruzar(Individuo padreA, Individuo padreB) {
		
		this.getCruzamientoAuxiliar(padreA).cruzar(padreA, padreB);
		
	}
	
	private CruzamientoBinomialMascaraComplemento getCruzamientoAuxiliar(Individuo individuo) {
		
		if (this.cruzamientoAuxiliarMascara == null) {
			
			StringBuffer mascaraA = new StringBuffer();
			
			for (int i = 0; i < individuo.getClass().getDeclaredFields().length; i++) {
				
				if (Math.random() <= 0.5) {
					mascaraA.append(Cruzamiento.X);
				}
				else {
					mascaraA.append(Cruzamiento.Y);
				}
			}
			
			this.cruzamientoAuxiliarMascara = new CruzamientoBinomialMascaraComplemento(mascaraA.toString());
		}
		
		return this.cruzamientoAuxiliarMascara;
	}
	
}
