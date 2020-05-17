package practico3;

public class Arco <T>{
	private Vertice<T> verticeOrigen;
	private Vertice<T> verticeDestino;
	private T etiqueta;

	
	public Arco(Vertice<T> verticeOrigen, Vertice<T> verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public Vertice<T> getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public Vertice<T> getVerticeDestino() {
		return verticeDestino;
	}
	
	private void setVerticeOrigen(Vertice<T> verticeid) {
		this.verticeOrigen = verticeid;
	}
	
	private void setVerticeDestino(Vertice<T> verticeid) {
		this.verticeDestino = verticeid;
	}

	public T getEtiqueta() {
		return etiqueta;
	}
	
	public boolean removeVertice(int idVertice)
	{
		int origenVerticeId = this.getVerticeOrigen().getId();
		int destinoVerticeId = this.getVerticeDestino().getId();
		
		if (origenVerticeId == idVertice) {
			this.setVerticeOrigen(null);
			return true;
		}
		
		if (destinoVerticeId == idVertice) {
			this.setVerticeDestino(null);
			return true;
		}
		
		return false;
	}
}
