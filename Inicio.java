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

		System.out.println("## Digite o seu nome de nome de usuário ##");
		System.out.print("Nome: ");
		novoUsuario = new Usuario(input.nextLine());
		listaUsuarios.add(novoUsuario);
		System.out.println();

		do {
			System.out.println("## Olá " + listaUsuarios.get(0).getNome() + ", escolha uma das opções abaixo ##");
			System.out.println("Opção 1 - Criar novo usuário");
			System.out.println("Opção 2 - Iniciar conversa");
			System.out.println("Opção 3 - Enviar mensagem");
			System.out.println("Opção 4 - Mostrar mensagens recebidas");
			System.out.println("Opção 5 - Mostrar mensagens enviadas");
			System.out.println("Opção 6 - Lista de conversas");
			System.out.println("Opção 7 - Mostrar todos os usuários criados");
			System.out.println("Opção 8 - Alternar usuário");
			System.out.println("Opção 0 - Encerrar programa");
			System.out.println("_____________________________________________");

			System.out.print("Digite aqui sua opção: ");
			opcaoMenu = Integer.parseInt(input.nextLine());

			if (opcaoMenu == 1) {
				System.out.print("Insira o nome do novo usuário: ");
				novoUsuario = new Usuario(input.nextLine());
				listaUsuarios.add(novoUsuario);
				System.out.println();
			} else if (opcaoMenu == 2) {
				int countCod = 0;
				System.out.println("## Selecione o usuário com quem deseja iniciar uma conversa ##");
				for (Usuario i : listaUsuarios) {
					System.out.println(i.getNome() + " | " + countCod);
					countCod++;
				}
				System.out.print("Insira o código do usuário: ");
				codContato = Integer.parseInt(input.nextLine());
				if (codContato != 0) {
					listaUsuarios.get(0).iniciarConversa(listaUsuarios.get(codContato));
					listaUsuarios.get(codContato).iniciarConversa(listaUsuarios.get(0));
				} else {
					System.out.println("!! Você não pode mandar iniciar uma conversa com você mesmo !!");
				}
				System.out.println();

			} else if (opcaoMenu == 3) {
				int countCod = 0;
				System.out.println("## Selecione o usuário que deseja enviar uma mensagem ##");
				for (Usuario i : listaUsuarios) {
					System.out.println(i.getNome() + " | " + countCod);
					countCod++;
				}
				System.out.print("Insira o código do usuário: ");
				codContato = Integer.parseInt(input.nextLine());
				if (codContato != 0) {
					System.out.print("Digite aqui sua mensagem: ");
					textoMensagem = input.nextLine();
					listaUsuarios.get(codContato).enviarMensagem(textoMensagem);
					listaUsuarios.get(0).adicionarMensagem(textoMensagem);
				} else {
					System.out.println("!! Você não pode mandar uma mensagem para você mesmo !!");
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
				System.out.println("## Você tem conversa abertas com ##");
				listaUsuarios.get(0).listarContatos();
				System.out.println();
				
			} else if (opcaoMenu == 7) {
				System.out.println("## Os usuários criados são ##");
				for (Usuario i : listaUsuarios) {
					System.out.println(i.getNome());
				}
				System.out.println();
			} else if(opcaoMenu == 8) {
				int countCod = 0;
				System.out.println("## Selecione o usuário para alternar ##");
				for (Usuario i : listaUsuarios) {
					System.out.println(i.getNome() + " | " + countCod);
					countCod++;
				}
				System.out.print("Insira o código do usuário: ");
				codContato = Integer.parseInt(input.nextLine());
				if (codContato != 0) {
					Usuario temp;
					temp = listaUsuarios.get(codContato);
					listaUsuarios.add(listaUsuarios.get(0));
					listaUsuarios.remove(0);
					listaUsuarios.remove(temp);
					listaUsuarios.add(0, temp);
				} else {
					System.out.println("!! Você já está utilizando esse usuário !!");
				}
			}

		} while (opcaoMenu != 0);

		input.close();
	}
}