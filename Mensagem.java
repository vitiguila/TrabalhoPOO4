package trabalho4;

public class Mensagem {
	private String texto;
	String statusMensagemTexto = "não-visualizada";

	public Mensagem(String texto) {
		this.texto = texto;
	}

	public void mudarStatusMensagem() {
		statusMensagemTexto = "visualizada";
	}

	public String getTexto() {
		return texto;
	}

	public String getStatus() {
		return statusMensagemTexto;
	}
}
