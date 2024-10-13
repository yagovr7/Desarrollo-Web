package Podcast;

public class Podcast {
	private int idPodcast;
	private String titulo;
	private int tipo;
	private String calidad;
	private int duracion;
	private String periocidad;
	private String formato_video;
	private int autor;
	Generos generos;
	
	Podcast(){
		this.idPodcast = 0;
		this.titulo = null;
		this.tipo = 0;
		this.calidad = null;
		this.duracion = 0;
		this.periocidad = null;
		this.formato_video = null;
		this.autor = 0;
	}
	
	Podcast(int id, String titulo, int tipo, String calidad, int duracion, String periodicidad, String formato, int autor){
		this.idPodcast = id;
		this.titulo = titulo;
		this.tipo = tipo;
		this.calidad = calidad;
		this.duracion = duracion;
		this.periocidad = periodicidad;
		this.formato_video = formato;
		this.autor = autor;
	}

	public int getIdPodcast() {
		return idPodcast;
	}

	public void setIdPodcast(int idPodcast) {
		this.idPodcast = idPodcast;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getPeriocidad() {
		return periocidad;
	}

	public void setPeriocidad(String periocidad) {
		this.periocidad = periocidad;
	}

	public String getFormato_video() {
		return formato_video;
	}

	public void setFormato_video(String formato_video) {
		this.formato_video = formato_video;
	}

	public int getAutor() {
		return autor;
	}

	public void setAutor(int autor) {
		this.autor = autor;
	}
	
	
}
