package frsf.isi.died.tp.taller03;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import frsf.isi.died.tp.estructuras.ArbolBinarioBusqueda;
import frsf.isi.died.tp.modelo.productos.Libro;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
import frsf.isi.died.tp.modelo.productos.Video;

public class TestPaso05 {

private ArbolBinarioBusqueda arbolBB1;
private Libro l1;
private Libro l2;
private Libro l3;
private Libro l4;
private Libro l5;
private Video v1;
private Video v2;
private Video v3;
private Video v4;
private Video v5;

@Before
public void init() {
arbolBB1 = new ArbolBinarioBusqueda((mc1,mc2)-> mc1.precio().intValue()- mc2.precio().intValue()); 
l1= new Libro(1, "Libro1", 10.0, 20.0, 154);
l2= new Libro(2, "Libro2", 20.0, 24.0, 361);
l3= new Libro(3, "Libro3", 15.0, 18.0, 108);
l4= new Libro(4, "Libro4", 30.0, 16.0, 250);
l5= new Libro(5, "Libro5", 24.0, 32.0, 545);
v1= new Video(7, "Video7", 28.0, 360);
v2= new Video(8, "Video8", 15.0, 625);
v3= new Video(9, "Video9", 30.0, 145);
v4= new Video(10, "Video10", 45.0, 38);
v5= new Video(11, "Video11", 12.0, 60);
}

@Test
public void testRango() {
arbolBB1.add(v1);
arbolBB1.add(v2);
arbolBB1.add(v3);
arbolBB1.add(v4);
arbolBB1.add(v5);
arbolBB1.add(l1);
arbolBB1.add(l2);
arbolBB1.add(l3);
arbolBB1.add(l4);
arbolBB1.add(l5); 
arbolBB1.imprimir();
System.out.println();
List<MaterialCapacitacion> lm=arbolBB1.rango(51.0,80.0);

assertTrue(lm.size()==2);
}
}
