package practico3;

public class Arco <T>{
	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etiqueta == null) ? 0 : etiqueta.hashCode());
		result = prime * result + verticeDestino;
		result = prime * result + verticeOrigen;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arco other = (Arco) obj;
		if (etiqueta == null) {
			if (other.etiqueta != null)
				return false;
		} else if (!etiqueta.equals(other.etiqueta))
			return false;
		if (verticeDestino != other.verticeDestino)
			return false;
		if (verticeOrigen != other.verticeOrigen)
			return false;
		return true;
	}

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}

}
