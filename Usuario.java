package trabalho4;

import java.util.ArrayList;

public class Usuario {
	private String nomeUsuario;
	private Conversa conversaContato;  
	ArrayList<Usuario> colecaoContatos = new ArrayList<Usuario>();
	ArrayList<Mensagem> mensagensEnviadas = new ArrayList<Mensagem>();


	public Usuario(String nomeUsuario) { 
		this.nomeUsuario = nomeUsuario;
	}

	public void iniciarConversa(Usuario nomeContato) {
		conversaContato = new Conversa(nomeContato);
		colecaoContatos.add(nomeContato);
		conversaContato.inserirNaConversa(this);
	}

	public void enviarMensagem(String texto) {
		conversaContato.enviarMensagem(texto);
	}
	public void adicionarMensagem(String texto) {
		Mensagem mensagemEnviada = new Mensagem(texto);
		mensagensEnviadas.add(mensagemEnviada);
	}

	public void imprimirMensagens() {
		conversaContato.imprimir();
	}
	public void mudarStatus() {
		if (mensagensEnviadas.size() != 0) {
			for (Mensagem i : mensagensEnviadas) {
				i.mudarStatusMensagem();
			}
		}
	}
	
	public void imprimirSuasMensagens() {
		for (Mensagem i : mensagensEnviadas) {
			System.out.println("Você disse: " + i.getTexto() + " | " + i.getStatus());
		}
	}

	public void listarContatos() {
		for (Usuario i : colecaoContatos) {
			System.out.println(i.getNome());
		}
	}

	public String getNome() {
		return nomeUsuario;
	}
}
