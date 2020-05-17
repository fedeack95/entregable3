package practico3;

import java.util.HashMap;
import java.util.Iterator;

public class Vertice<T>{
	private HashMap<Integer,Arco<T>> arcos;
	private int id;
	public Vertice (int id ) {
		this.arcos = new HashMap<Integer,Arco<T>>();
		this.id = id;
	}
	
	public void addArco (Vertice<T> v, T etiqueta) {
		if(!this.contieneArco(v.getId())) {
			Arco<T> newArco = new Arco<T>(this,v,etiqueta);
			this.arcos.put(v.id, newArco);
		}
	}
	
	
	public boolean contieneArco(int id) {
		
		return this.arcos.get(id) != null;
	}
	
	public Arco<T> getArco(int id) {
		return this.arcos.get(id);
	}
	
	public  Iterator<Arco<T>> getArcos() {
		return this.arcos.values().iterator();
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean removeArco(int idArco) {
		Arco<T> arco = this.arcos.get(idArco);
		return this.arcos.remove(idArco, arco);
	}
	
	public boolean removeVerticeInArco (int idVertice) {
		Iterator<Arco<T>> iterator = this.arcos.values().iterator();
		boolean isDeleted = false;
		while (iterator.hasNext()) {
			Arco<T> current = iterator.next();
			isDeleted = current.removeVertice(idVertice);
		}
		return isDeleted;
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
