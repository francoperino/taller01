package frsf.isi.died.tp.modelo;

import java.awt.List;
import java.util.Arrays;
import java.util.Collection;

import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.util.ListaServiceRadix;
import frsf.isi.died.tp.util.ListasService;


/**
 * Esta clase implementa la interface Biblioteca y todas sus operaciones, gestionando todos los
 * @see MaterialCapacitacion en un arreglo.
 * @author mdominguez
 *
 */
public class BibliotecaArray implements Biblioteca{

	/**
	 * Arreglo donde se almacenan todos los materiales de capacitacion
	 */
	private MaterialCapacitacion[] materialCapacitacion;
	/**
	 * Variable interna de control que se utiliza para llevar registro de cuantos materiales 
	 * se llevan insertados. Se utiliza para evitar insertar un nuevo material fuera de rango
	 * y tambien para responder la consulta acerca de cuantos materiales hay insertados
	 */
	private Integer cantidadMaterial;
	private ListasService var;
	// TODO 12: crear una variable de tipo ListaService que apuntará a una instancia del servicio de operaciones de lista

	
	public BibliotecaArray() {
		cantidadMaterial=0;
		this.materialCapacitacion= new MaterialCapacitacion[10];
		// TODO 13: inicializar la variable de tipo ListaService para que apunte el servicio de operaciones de listas
		var = new ListaServiceRadix(this.materialCapacitacion);
	}

	@Override
	public void agregar(MaterialCapacitacion material) {
		
		
		if(cantidadMaterial<5) {
			this.materialCapacitacion[cantidadMaterial] = material;
			cantidadMaterial++;
		}
		
		
	}

	@Override
	public Integer cantidadMateriales() {
		
		
		return cantidadMaterial;
	}



	@Override
	public Integer cantidadLibros() {
		
		Integer cant=0;
		for(int i=0;i<cantidadMaterial;i++) {
		if(this.materialCapacitacion[i].esLibro())
			cant++;
		}
		
		
		return cant;
	}



	@Override
	public Integer cantidadVideos() {
		 
		 
		Integer cant=0;
		for(int i=0;i<cantidadMaterial;i++) {
		if(this.materialCapacitacion[i].esVideo())
			cant++;
		}
		
		return cant;
	}

	@Override
	public void imprimir() {		
		//TODO 14: invocar al método imprimir de la variable de tipo ListaService para que imprima el arreglo
		var.imprimir();
	}
		

	@Override
	public void ordenarPorPrecio(Boolean b) {
		// TODO 15: invocar al metodo ordenar de la variable de tipo ListaService para que ordene el arreglo
		var.ordenar();
	}


	@Override
	public Collection<MaterialCapacitacion> materiales() {
		return Arrays.asList(this.materialCapacitacion);
	}

	@Override
	public MaterialCapacitacion buscar(Integer precio) {
	// TODO Auto-generated method stub
	return null;
	}

}
