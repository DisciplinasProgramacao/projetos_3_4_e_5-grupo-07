package projeto;

public class Avaliacao {

	private double nota;
	private String comentario;
	
	public Avaliacao(double nota, String comentario) {
		this.nota = nota;
		this.comentario = (!comentario.equals("NULL"))? comentario:null;
	}

	public Avaliacao(double nota) {
		this(nota, null);
	}

	public double getNota() {
		return nota;
	}

	public String getComentario() {
		return (comentario != null)? comentario:"NULL";
	}
}
