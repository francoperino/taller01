package frsf.isi.died.tp.modelo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

import frsf.isi.died.tp.util.Ordenable;

public class BibliotecaList implements Biblioteca {

	private ArrayList<MaterialCapacitacion> materiales;
	public BibliotecaList() {
		this.materiales = new ArrayList<>();
	}
	@Override
	public void agregar(MaterialCapacitacion material) {
		this.materiales.add(material);
	}
	@Override
	public Integer cantidadMateriales() {
		return materiales.size();
	}
	@Override
	public Integer cantidadLibros() {
		Integer x=0;
		for (MaterialCapacitacion mat : this.materiales) {
			if(mat.esLibro())
				x++;
		}
		return x;
	}
	
	@Override
	public Integer cantidadVideos() {
		Integer x=0;
		for (MaterialCapacitacion mat : this.materiales) {
			if(mat.esVideo())
				x++;
		}
		return x;
	}
	@Override
	public Collection<MaterialCapacitacion> materiales() {
		
		return this.materiales();
	}
	@Override
	public void imprimir() {
		int i=0;
		for (MaterialCapacitacion mat : this.materiales) {
			if(mat!=null) System.out.println("Elemento en posicion "+(++i)+": "+mat);
		}
		
	}
	@Override
	public void ordenarPorPrecio(Boolean b) {
		if(b) {
			Collections.sort(materiales, (m1,m2)-> m1.precio().compareTo(m2.precio()));
		}
		else {
			Collections.sort(materiales);
		}
			
		
	}
	@Override
	public MaterialCapacitacion buscar (Integer costo) {
		Collections.sort(materiales, (m1,m2)-> m1.getCosto().compareTo(m2.getCosto()));
		return buscadorBinario(0,this.cantidadMateriales(),costo);
		
	}
	
	private MaterialCapacitacion buscadorBinario(Integer i, Integer f, Integer c) {
		if(i>=f) {
			if(c==this.materiales.get(f).getCosto().intValue()) {
				return this.materiales.get(f);
			}
			else
			throw new RuntimeException("Material de precio "+c+" no encontrado");
		}
		else {
			Integer mitad=(i+f)/2;
			int precioMaterial=this.materiales.get(mitad).getCosto().intValue();
			if(c==precioMaterial) {
				return this.materiales.get(mitad);
			}
			else {
				if(c<precioMaterial) {
					return buscadorBinario(i,mitad-1,c);
				}
				else
					return buscadorBinario(mitad+1,f,c);
				
			}
				
		}
	}
}
