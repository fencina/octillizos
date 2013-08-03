package main.java.ar.edu.utn.frba.ia.ag.cruzamiento;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Simple extends Cruzamiento {
	
	CruzamientoBinomialMascaraComplemento cruzamientoAuxiliarMascara;
	
	@Override
	protected void cruzar(Individuo padreA, Individuo padreB) {
		
		getCruzamientoAuxiliar(padreA).cruzar(padreA, padreB);
		
	}
	
	private CruzamientoBinomialMascaraComplemento getCruzamientoAuxiliar(Individuo individuo) {
		
		if (this.cruzamientoAuxiliarMascara == null) {
			
			StringBuffer mascara = new StringBuffer();
			
			int cantX = (int)(Math.random() * individuo.getClass().getDeclaredFields().length);
			
			for (int i = 0; i < cantX; i++) {
				mascara.append(X);
			}
			
			for (int i = mascara.length(); i < individuo.getClass().getDeclaredFields().length; i++) {
				mascara.append(Y);
			}
			
			this.cruzamientoAuxiliarMascara = new CruzamientoBinomialMascaraComplemento(mascara.toString());
			
		}
		
		return this.cruzamientoAuxiliarMascara;
	}
	
}