package trabalho4;

import java.util.ArrayList;

public class Conversa {
	private Usuario nomeUsuario;
	private Usuario nomeContato;
	Mensagem mensagem;
	private ArrayList<Mensagem> colecaoConversa = new ArrayList<Mensagem>();

	public Conversa(Usuario nomeContato) {
		this.nomeContato = nomeContato;
	}

	public void enviarMensagem(String texto) {
		mensagem = new Mensagem(texto);
		colecaoConversa.add(mensagem);
	}

	public void imprimir() {
		if (colecaoConversa.size() != 0) {
			for (Mensagem i : colecaoConversa) {
				i.mudarStatusMensagem();
				System.out.println(nomeContato.getNome() + " disse: " + i.getTexto() + " | " + i.getStatus());
			}
			for (Mensagem i : nomeUsuario.mensagensEnviadas) {
				i.mudarStatusMensagem();
			}
			for (Mensagem i : nomeContato.mensagensEnviadas) {
				i.mudarStatusMensagem();
			}
		}
	}

	public void inserirNaConversa(Usuario nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNome() {
		return nomeContato.getNome();
	}
}
