package practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Vertice<T>{
	private HashMap<Integer,Arco<T>> arcos;
	private int id;
	public Vertice (int id ) {
		this.arcos = new HashMap<Integer,Arco<T>>();
		this.id = id;
	}
	
	public void addArco (Vertice<T> v, T etiqueta) {
		if(!this.contieneArco(v.getId())) {
			Arco<T> newArco = new Arco<T>(this.id,v.id,etiqueta);
			this.arcos.put(v.id, newArco);
		}
	}
	
	
	public boolean contieneArco(int id) {
		
		return this.arcos.get(id) != null;
	}
	
	public Arco<T> getArco(int id) {
		return this.arcos.get(id);
	}
	
	public  HashMap<Integer,Arco<T>> getArcos() {
		return this.arcos;
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean removeArco(int idArco,Vertice<T> v) {
		return this.arcos.remove(idArco, v);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arcos == null) ? 0 : arcos.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Integer other = (int) obj;
		return (id != other);
		
	}
	
	
}
