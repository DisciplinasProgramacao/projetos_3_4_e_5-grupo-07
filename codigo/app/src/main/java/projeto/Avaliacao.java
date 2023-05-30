package projeto;

public class Avaliacao {

	private float nota;
	private String comentario;
	private String data;
	
	public Avaliacao(float nota, String comentario) {
		this.nota = nota;
		this.comentario = comentario;
	}

	public Avaliacao(float nota) {
		this.nota = nota;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
