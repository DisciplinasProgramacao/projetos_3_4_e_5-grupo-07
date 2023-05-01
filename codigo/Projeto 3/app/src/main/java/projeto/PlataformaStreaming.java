package projeto;

public class PlataformaStreaming{
    private String nome;
    private Hash<Serie> series;
    private Hash<Clientes> clientes;
    private Cliente clienteAtual;
}

public String getNome() {
			return nome;
}
public void setNome(String nome) {
			this.nome = nome;
}
public Cliente getClienteAtual() {
			return clienteAtual;
}
public void setClienteAtual(Cliente clienteAtual) {
			this.clienteAtual = clienteAtual;
}
public Hash<Serie> getSeries(){
    return series;
}
public void setSeries (Hash<Serie> series){
    this.series=series;
}
public Hash<Cliente> getCliente(){
    return cliente;
}
public void setCliente (Hash<Cliente> cliente){
    this.series=series;
}

public Cliente login(String nomeUsuario, String senha){
    for(Cliente c : clientes.values()){
        if(c.getNomeDeUsuario().equals(nomeUsuario) && c.getSenha().equals(senha)){
            setClienteAtual(c);
            return c;
        }
    }
    
    return null;
}