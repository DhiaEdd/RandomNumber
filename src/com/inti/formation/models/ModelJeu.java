package com.inti.formation.models;

import java.util.ArrayList;
import java.util.List;

public class ModelJeu {
	
	private int nombre;
	private List<String> historiques = new ArrayList<String>();
	public ModelJeu() {
		super();
	}
	public ModelJeu(int nombre, List<String> historiques) {
		super();
		this.nombre = nombre;
		this.historiques = historiques;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public List<String> getHistoriques() {
		return historiques;
	}
	public void setHistoriques(List<String> historiques) {
		this.historiques = historiques;
	}
	@Override
	public String toString() {
		return "ModelJeu [nombre=" + nombre + ", historiques=" + historiques + "]";
	}

}
