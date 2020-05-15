package practico3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

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
	public void borrarVertice(int verticeId) {
		//buscar en todos los arcos y eliminar el vertice 
	    if(this.contieneVertice(verticeId)) {
			 this.vertices.remove(verticeId);
		}

	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		
		if(!this.existeArco(verticeId1, verticeId2)) {
			Arco<T> newArco = new Arco<T>(verticeId1, verticeId2, etiqueta);
			Vertice<T> newVertice = new Vertice<T> (verticeId2);
			this.vertices.get(verticeId1).addArco(newVertice,etiqueta);
			this.cantArcos++;
		}

	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (this.contieneVertice(verticeId1)) {
			Vertice v = this.vertices.get(verticeId1);
			if(!v.contieneArco(verticeId2)) {
				 v.removeArco(verticeId2, v);
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
		// TODO Auto-generated method stub
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

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO uto-generated method stub
		return null;
	}

	//por ahora no hace falta
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		
		return null;
	}


}
