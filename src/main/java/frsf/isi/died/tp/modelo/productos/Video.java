package frsf.isi.died.tp.modelo.productos;

public class Video extends MaterialCapacitacion{

	private static final double costoSegundo = 0.15;
	private Integer duracion;
	
	
	  public Video() {
	}   
	  public Video(Integer id,String titulo) {
		  this.id= id;
		  this.titulo=titulo;
	}     
	  public Video(Integer id,String titulo, Double costo,Integer duracion) {
		  this.id= id;
		  this.titulo=titulo;
		  this.costo=costo;
		  this.duracion = duracion;
	}
	@Override
	public Double precio() {
		
		return (costo + (this.costoSegundo*this.duracion));
	}

	@Override
	public Boolean esLibro() {
		
		return false;
	}

	@Override
	public Boolean esVideo() {
		
		return (this instanceof Video);
	}

}
