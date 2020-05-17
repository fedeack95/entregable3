package practico3;

public class Main {

	public static void main(String[] args) {
		GrafoDirigido<String> gf = new GrafoDirigido<String>();
		
		gf.agregarArco(1,2, "ruta 1");
		gf.agregarArco(2,1, "ruta 1");
		System.out.println(gf.existeArco(4, 5));
		System.out.println(gf.obtenerArco(1, 2));
		System.out.println(gf.obtenerArco(2, 1));
		System.out.println(gf.cantidadArcos());
		gf.borrarArco(2, 1);
		System.out.println(gf.cantidadArcos());
		
		
		
		
		

	}

}
