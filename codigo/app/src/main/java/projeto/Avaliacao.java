package projeto;

public class Avaliacao {

	private double nota;
	private String comentario;
	private String data;
	
	public Avaliacao(double nota, String comentario) {
		this.nota = nota;
		this.comentario = comentario;
	}

	public Avaliacao(double nota) {
		this.nota = nota;
	}

	public double getNota() {
		return nota;
	}

	public String getComentario() {
		return comentario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
