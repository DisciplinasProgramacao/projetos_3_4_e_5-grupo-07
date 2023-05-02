package projeto;

import java.util.HashMap;

public class PlataformaStreaming{
    private String nome;
    private HashMap<String, Serie> series;
    private HashMap<String, Cliente> clientes;
    private Cliente clienteAtual;

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
}
