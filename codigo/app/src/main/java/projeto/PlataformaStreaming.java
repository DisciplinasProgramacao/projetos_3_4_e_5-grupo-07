package projeto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import projeto.exceptions.ClienteSemAcesso;

public class PlataformaStreaming{
    private String nome;
	private Map<String, Lancamento> lancamentos = new HashMap<>();
    private Map<String, Midia> midias = new HashMap<>();
    private Map<String, Cliente> clientes = new HashMap<>();;
    private Cliente clienteAtual;

	public void adicionarMidia(Midia midia) {
		midias.put(midia.getNome(), midia);
	}

	public void adicionarLancamento(Midia midia) {
		lancamentos.put(midia.getNome(), new Lancamento(midia));
	}

	public void adicionarCliente(Cliente cliente) {
		clientes.put(cliente.getNome(), cliente);
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

	public List<Midia> getMidias(){
		return new ArrayList<>(midias.values());
	}

	public List<Midia> getLancamentos() throws ClienteSemAcesso {
		if (!(clienteAtual instanceof  ClienteProfissional)) 
			throw new ClienteSemAcesso();
		return lancamentos.values().parallelStream()
		.map(Lancamento::getMidia).toList();
	}

	public void setClientes (final HashMap<String, Cliente> clientes){
		this.clientes = clientes;
	}

	public boolean login(final String nomeUsuario, final String senha){
		clienteAtual = clientes.values().parallelStream()
		.filter(c -> c.login(nomeUsuario, senha))
		.findFirst()
		.orElse(null);
		return clienteAtual != null;
	}

	public void logout() {
		clienteAtual = null;
	}

	public boolean estaLogado() {
		return clienteAtual != null;
	}

	public List<Midia> filtrarPorGenero(String genero) {
		return midias.values().parallelStream()
		.filter(midia -> midia.getGenero().toString().equals(genero))
		.toList();
	}

	public List<Serie> filtrarPorQtdEpisodios(int nEpisodios) {
		return midias.values().parallelStream()
		.filter(Serie.class::isInstance)
		.map(Serie.class::cast)
		.filter(serie -> serie.getQuantidadeDeEpisodios() == nEpisodios)
		.toList();
	}

	public List<Midia> filtrarPorIdioma(String idioma) {
		return midias.values().parallelStream()
		.filter(serie -> serie.getIdioma().toString().equals(idioma))
		.toList();
	}

	public void assistir(Midia midia) {
		midia.assistir(clienteAtual);
	}

	public String salvarSeries() {
		return midias.values().parallelStream()
		.filter(Serie.class::isInstance)
		.map(Midia::salvar)
		.collect(Collectors.joining("\n"));
	}

	public String salvarFilmes() {
		return midias.values().parallelStream()
		.filter(Filme.class::isInstance)
		.map(Midia::salvar)
		.collect(Collectors.joining("\n"));
	}

	public String salvarLancamentos() {
		return lancamentos.values().parallelStream()
		.map(Lancamento::salvar)
		.collect(Collectors.joining("\n"));
	}

	public String salvarClientes() {
		return clientes.values().parallelStream()
			.map(Cliente::salvar)
			.collect(Collectors.joining("\n"));
	}

	public String salvarAudiencia() {
		return midias.values().parallelStream()
		.map(Midia::salvarAudiencia)
		.collect(Collectors.joining("\n"));
	}

	public String salvarAvaliacoes() {
		return clientes.values().parallelStream()
		.map(Cliente::salvarAvaliacoes)
		.collect(Collectors.joining("\n"));
	}

	public void carregarSeries(List<String> linhascsv) {
		linhascsv.parallelStream().forEach(linha -> {
			Serie serie = Serie.carregar(linha);
			midias.put(serie.getNome(), serie);
		});
	}

	public void carregarFilmes(List<String> linhascsv) {
		linhascsv.parallelStream().forEach(linha -> {
			Filme filme = Filme.carregar(linha);
			midias.put(filme.getNome(), filme);
		});
	}

	public void carregarLancamentos(List<String> linhascsv) {
		linhascsv.parallelStream().forEach(linha -> {
			Lancamento lancamento = Lancamento.carregar(linha);
			lancamentos.put(lancamento.getMidia().getNome(), lancamento);
		});
	}

	public void carregarClientes(List<String> linhascsv) {
		linhascsv.parallelStream().forEach(linha -> {
			Cliente cliente = Cliente.carregar(linha);
			clientes.put(cliente.getNome(), cliente);
		});
	}

	public void carregarAvaliacoes(List<String> linhascsv) {
		linhascsv.parallelStream().forEach(linha -> {
			String[] separada = linha.split(";");
			Cliente cliente = clientes.get(separada[0]);
			Arrays.stream(Arrays.copyOfRange(separada, 1, separada.length))
				.forEach(avaliacao -> {
					String[] dados = avaliacao.split(",");
					Midia midia = midias.get(dados[0]);
					double nota = Double.parseDouble(dados[1]);
					String comentario = dados[2];
					try {
						cliente.avalia(midia, nota, comentario);
					} catch (Exception e) {}
				});
		});
	}

	public void carregarAudiencia(List<String> linhascsv) {
		linhascsv.parallelStream().forEach(linha -> {
			String[] separada = linha.split(";");
			Midia midia = midias.get(separada[0]);
			Arrays.stream(separada[1].split(","))
				.forEach(nomeCliente -> {
					midia.assistir(nomeCliente);
				});
		});
	}
}
