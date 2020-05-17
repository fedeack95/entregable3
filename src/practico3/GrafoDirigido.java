package practico3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	
	private HashMap<Integer, Vertice<T>> vertices ;
	private int cantArcos;
	public GrafoDirigido() {
		this.vertices = new HashMap<Integer,Vertice<T>>();
		this.cantArcos = 0;
		
	}
	
	
	@Override
	public void agregarVertice(int verticeId) {
		if(!this.contieneVertice(verticeId)) {			
			Vertice<T> vertice = new Vertice<T>(verticeId);
			this.vertices.put(verticeId, vertice);
		}
	}

	@Override
	public boolean borrarVertice(int verticeId) {
		//buscar en todos los arcos y eliminar el vertice
		Iterator<Vertice<T>> iterator = this.getVertices();
		boolean isDeleted = false;
		while(iterator.hasNext()) {
		   Vertice<T> current = iterator.next();
		   isDeleted = current.removeVerticeInArco(verticeId);
		}
		
	    return isDeleted;
	}
	

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(!this.existeArco(verticeId1, verticeId2)) {
			this.agregarVertice(verticeId1);
			this.agregarVertice(verticeId2);
			Vertice<T> v1 = this.vertices.get(verticeId1);
			Vertice<T> v2 = this.vertices.get(verticeId2);
			v1.addArco(v2, etiqueta);
	        this.cantArcos++;
		}

	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (this.contieneVertice(verticeId1)) {
			Vertice<T> v = this.vertices.get(verticeId1);
			if(v.contieneArco(verticeId2)) {
				 v.removeArco(verticeId2);
				 cantArcos--;
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.vertices.get(verticeId) != null;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if(this.vertices.size() == 0) {
			return false;
		}
		if(!this.contieneVertice(verticeId1)) {
			 return false;
		}
		return this.vertices.get(verticeId1).contieneArco(verticeId2);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(!this.contieneVertice(verticeId1)) {
			return null;
		}
		Arco<T> output = this.vertices.get(verticeId1).getArco(verticeId2);
		return output;
	}

	@Override
	public int cantidadVertices() {
		return this.vertices.size();
	}

	@Override
	public int cantidadArcos() { 
		return this.cantArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		Collection<Vertice<T>> values = this.vertices.values();
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(Vertice<T> value : values ) {
			output.add(value.getId());
		}
		return output.iterator();
	}
	
	
	private Iterator<Vertice<T>> getVertices() {
		Collection<Vertice<T>> values = this.vertices.values();
		return values.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
	   return this.vertices.get(verticeId).getArcos();
	}
	
	public void DFS() {
		
	}

}
