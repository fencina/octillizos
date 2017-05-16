package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

public enum AromasEnum {
	CITRICO("cítrico"),
	FLORAL("floral"),
	FRUTAL("frutal"),
	ORIENTAL("oriental"),
	ACARAMELADO("acaramelado"),
	OCEANICO("oceánico"),
	ESPECIADO("especiado"),
	AMADERADO("amaderado");
	
	private String string;
	
	private AromasEnum(String string){
		this.string = string;
	}
	
	public String getString(){
		return this.string;
	}
}
