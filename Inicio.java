package trabalho4;

import java.util.ArrayList;
import java.util.Scanner;

public class Inicio {
	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		Usuario novoUsuario;
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Scanner input = new Scanner(System.in);
		int opcaoMenu = 0;
		int codContato;
		String textoMensagem;

		System.out.println("## Digite o seu nome de nome de usu�rio ##");
		System.out.print("Nome: ");
		novoUsuario = new Usuario(input.nextLine());
		listaUsuarios.add(novoUsuario);
		System.out.println();

		do {
			System.out.println("## Ol� " + listaUsuarios.get(0).getNome() + ", escolha uma das op��es abaixo ##");
			System.out.println("Op��o 1 - Criar novo usu�rio");
			System.out.println("Op��o 2 - Iniciar conversa");
			System.out.println("Op��o 3 - Enviar mensagem");
			System.out.println("Op��o 4 - Mostrar mensagens recebidas");
			System.out.println("Op��o 5 - Mostrar mensagens enviadas");
			System.out.println("Op��o 6 - Lista de conversas");
			System.out.println("Op��o 7 - Mostrar todos os usu�rios criados");
			System.out.println("Op��o 8 - Alternar usu�rio");
			System.out.println("Op��o 0 - Encerrar programa");
			System.out.println("_____________________________________________");

			System.out.print("Digite aqui sua op��o: ");
			opcaoMenu = Integer.parseInt(input.nextLine());

			if (opcaoMenu == 1) {
				System.out.print("Insira o nome do novo usu�rio: ");
				novoUsuario = new Usuario(input.nextLine());
				listaUsuarios.add(novoUsuario);
				System.out.println();
			} else if (opcaoMenu == 2) {
				int countCod = 0;
				System.out.println("## Selecione o usu�rio com quem deseja iniciar uma conversa ##");
				for (Usuario i : listaUsuarios) {
					System.out.println(i.getNome() + " | " + countCod);
					countCod++;
				}
				System.out.print("Insira o c�digo do usu�rio: ");
				codContato = Integer.parseInt(input.nextLine());
				if (codContato != 0) {
					listaUsuarios.get(0).iniciarConversa(listaUsuarios.get(codContato));
					listaUsuarios.get(codContato).iniciarConversa(listaUsuarios.get(0));
				} else {
					System.out.println("!! Voc� n�o pode mandar iniciar uma conversa com voc� mesmo !!");
				}
				System.out.println();

			} else if (opcaoMenu == 3) {
				int countCod = 0;
				System.out.println("## Selecione o usu�rio que deseja enviar uma mensagem ##");
				for (Usuario i : listaUsuarios) {
					System.out.println(i.getNome() + " | " + countCod);
					countCod++;
				}
				System.out.print("Insira o c�digo do usu�rio: ");
				codContato = Integer.parseInt(input.nextLine());
				if (codContato != 0) {
					System.out.print("Digite aqui sua mensagem: ");
					textoMensagem = input.nextLine();
					listaUsuarios.get(codContato).enviarMensagem(textoMensagem);
					listaUsuarios.get(0).adicionarMensagem(textoMensagem);
				} else {
					System.out.println("!! Voc� n�o pode mandar uma mensagem para voc� mesmo !!");
				}
				System.out.println();
				
			} else if (opcaoMenu == 4) {
				System.out.println("## Suas mensagens recebidas ##");
				listaUsuarios.get(0).imprimirMensagens();
				System.out.println();
				
			} else if (opcaoMenu == 5) {
				System.out.println("## Suas mensagens enviadas ##");
				for(Usuario i: listaUsuarios) {
					if(i == listaUsuarios.get(0))
						i.imprimirSuasMensagens();
					}
				System.out.println();
			} else if (opcaoMenu == 6) {
				System.out.println("## Voc� tem conversa abertas com ##");
				listaUsuarios.get(0).listarContatos();
				System.out.println();
				
			} else if (opcaoMenu == 7) {
				System.out.println("## Os usu�rios criados s�o ##");
				for (Usuario i : listaUsuarios) {
					System.out.println(i.getNome());
				}
				System.out.println();
			} else if(opcaoMenu == 8) {
				int countCod = 0;
				System.out.println("## Selecione o usu�rio para alternar ##");
				for (Usuario i : listaUsuarios) {
					System.out.println(i.getNome() + " | " + countCod);
					countCod++;
				}
				System.out.print("Insira o c�digo do usu�rio: ");
				codContato = Integer.parseInt(input.nextLine());
				if (codContato != 0) {
					Usuario temp;
					temp = listaUsuarios.get(codContato);
					listaUsuarios.add(listaUsuarios.get(0));
					listaUsuarios.remove(0);
					listaUsuarios.remove(temp);
					listaUsuarios.add(0, temp);
				} else {
					System.out.println("!! Voc� j� est� utilizando esse usu�rio !!");
				}
			}

		} while (opcaoMenu != 0);

		input.close();
	}
}