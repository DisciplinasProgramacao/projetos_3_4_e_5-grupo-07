package projeto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlataformaStreaming{
    private String nome;
    private Map<String, Serie> series = new HashMap<String, Serie>();
    private Map<String, Filme> filmes = new HashMap<String, Filme>();
    private Map<String, Cliente> clientes = new HashMap<String, Cliente>();;
    private Cliente clienteAtual;

	public void adicionarSerie(Serie serie) {
		series.put(serie.getNome(), serie);
	}

	public void adicionarCliente(Cliente cliente) {
		clientes.put(cliente.getNome(), cliente);
	}

	public void adicionarFilme(Filme filme) {
        filmes.put(filme.getNome(), filme);
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

	public Map<String, Serie> getSeries(){
		return series;
	}

	public void setSeries (final HashMap<String, Serie> series){
		this.series = series;
	}

	public Map<String, Cliente> getClientes(){
		return clientes;
	}

	public void setClientes (final HashMap<String, Cliente> clientes){
		this.clientes = clientes;
	}

	public boolean login(final String nomeUsuario, final String senha){
		clienteAtual = clientes.values().stream()
		.filter(c -> c.login(nomeUsuario, senha))
		.findFirst()
		.orElse(null);
		return clienteAtual != null;
	}

	public boolean estaLogado() {
		return clienteAtual != null;
	}

	public List<Serie> filtrarPorGenero(String genero) {
		return series.values().stream()
		.filter(serie -> serie.getGenero().toString().equals(genero)).collect(Collectors.toList());
	}

	public List<Serie> filtrarPorQtdEpisodios(int nEpisodios) {
		return series.values().stream()
		.filter(serie -> serie.getQuantidadeDeEpisodios() == nEpisodios).collect(Collectors.toList());
	}

	public List<Serie> filtrarPorIdioma(String idioma) {
		return series.values().stream()
		.filter(serie -> serie.getIdioma().toString().equals(idioma)).collect(Collectors.toList());
	}

	public void registrarAudiencia(Serie serie) {
		serie.registrarAudiencia();
	}

	public String salvarSeries() {
		return series.values().stream()
		.map(Serie::salvar)
		.collect(Collectors.joining("\n"));
	}

	public String salvarFilmes() {
		return filmes.values().stream()
		.map(Filme::salvar)
		.collect(Collectors.joining("\n"));
	}

	public String salvarClientes() {
		return clientes.values().stream()
			.map(Cliente::salvar)
			.collect(Collectors.joining("\n"));
	}

	public void carregarSeries(List<String> linhascsv) {
		linhascsv.stream().forEach(linha -> {
			Serie serie = Serie.carregar(linha);
			series.put(serie.getNome(), serie);
		});
	}

	public void carregarFilmes(List<String> linhascsv) {
		linhascsv.stream().forEach(linha -> {
			Filme filme = Filme.carregar(linha);
			filmes.put(filme.getNome(), filme);
		});
	}

	public void carregarClientes(List<String> linhascsv) {
		linhascsv.stream().forEach(linha -> {
			Cliente cliente = Cliente.carregar(linha);
			clientes.put(cliente.getNome(), cliente);
		});
	}
}
