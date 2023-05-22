package projeto;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PlataformaStreaming{
    private String nome;
    private HashMap<String, Serie> series = new HashMap<String, Serie>();
    private HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();;
    private Cliente clienteAtual;

	public void adicionarSerie(Serie serie) {
		series.put(serie.getNome(), serie);
	}

	public void adicionarCliente(Cliente cliente) {
		clientes.put(cliente.getNomeDeUsuario(), cliente);
	}

	
	public void adicionarFilme(Filme filme) {
        filme.put(filme.getId(), filme);
    	}
	
	public String getNome() {
				return nome;
	}
	public void setNome(final String nome) {
				this.nome = nome;
	}
	public Cliente getClienteAtual() {
				return clienteAtual;
	}
	public void setClienteAtual(final Cliente clienteAtual) {
				this.clienteAtual = clienteAtual;
	}
	public HashMap<String, Serie> getSeries(){
		return series;
	}
	public void setSeries (final HashMap<String, Serie> series){
		this.series = series;
	}
	public HashMap<String, Cliente> getClientes(){
		return clientes;
	}
	public void setClientes (final HashMap<String, Cliente> clientes){
		this.clientes = clientes;
	}

	public Cliente login(final String nomeUsuario, final String senha){
		for(Cliente c : clientes.values()){
			if(c.getNomeDeUsuario().equals(nomeUsuario) && c.getSenha().equals(senha)){
				clienteAtual = c;
				return c;
			}
		}
		return null;
	}

	public List<Serie> filtrarPorGenero(String genero) {
		return series.values().stream()
		.filter(serie -> serie.getGenero().equals(genero)).collect(Collectors.toList());
	}

	public List<Serie> filtrarPorQtdEpisodios(int nEpisodios) {
		return series.values().stream()
		.filter(serie -> serie.getQuantidadeDeEpisodios() == nEpisodios).collect(Collectors.toList());
	}

	public List<Serie> filtrarPorIdioma(String idioma) {
		return series.values().stream()
		.filter(serie -> serie.getIdioma().equals(idioma)).collect(Collectors.toList());
	}

	public void registrarAudiencia(Serie serie) {
		serie.registrarAudiencia();
	}
}
