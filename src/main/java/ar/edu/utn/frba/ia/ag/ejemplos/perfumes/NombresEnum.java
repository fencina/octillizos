package main.java.ar.edu.utn.frba.ia.ag.ejemplos.perfumes;

public enum NombresEnum {
	TOMMY("Tommy"),
	POLO("Polo"),
	DANDG("D&G"),
	CK("CK"),
	PR("PR"),
	CHANEL("Channel"),
	BANDERAS("Banderas"),
	CH("CH");
	
	private String nombre;
	
	private NombresEnum(String name)
	{
		this.nombre = name;
	}
	
	public String getString(){
		return this.nombre;
	}
	
}
