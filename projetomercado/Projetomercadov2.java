package projetomercado;

import java.util.*;

public class Projetomercadov2 {
	static boolean cadastrado = false;
	static int contador = 0;
	static String[] nome = new String[1000];
	static double[] preco = new double[1000];
	static int[] cod = new int[1000];
	static String[] categoria = new String[1000];
	static int[] qtdEstoque = new int[1000];

	public static void cadastrarProd(int codigo) {
		int encerrar;

		Scanner sc = new Scanner(System.in);

		int codi, estoque;
		String name, category;
		double precin;

		switch (codigo) {

		case 1: {
			boolean encontrado = false;

			for (int i = 0; i < cod.length; i++) {
				if (categoria[i] != null && categoria[i].equalsIgnoreCase("limpeza")) {
					System.out.println("Nome do produto: " + nome[i]);
					System.out.println("Código do produto: " + cod[i]);
					System.out.println("Preço do produto: " + preco[i]);
					System.out.println("Categoria do produto: " + categoria[i]);
					System.out.println("Quantidade em estoque: " + qtdEstoque[i] + "\n");

					encontrado = true;
				}
			}

			if (!encontrado) {
				System.out.println("Produto não encontrado.");
			}
			conferirCAD();
			break;
		}

		case 2: {
			boolean encontrado = false;

			for (int i = 0; i < cod.length; i++) {
				if (categoria[i] != null && categoria[i].equalsIgnoreCase("frutas")) {
					System.out.println("Nome do produto: " + nome[i]);
					System.out.println("Código do produto: " + cod[i]);
					System.out.println("Preço do produto: " + preco[i]);
					System.out.println("Categoria do produto: " + categoria[i]);
					System.out.println("Quantidade em estoque: " + qtdEstoque[i] + "\n");

					encontrado = true;
				}
			}
			if (!encontrado) {
				System.out.println("Produto não encontrado.");
			}

			conferirCAD();
			break;

		}

		case 3: {
			boolean encontrado = false;
			for (int i = 0; i < cod.length; i++) {
				if (categoria[i] != null && categoria[i].equalsIgnoreCase("mercearia")) {
					System.out.println("Nome do produto: " + nome[i]);
					System.out.println("Código do produto: " + cod[i]);
					System.out.println("Preço do produto: " + preco[i]);
					System.out.println("Categoria do produto: " + categoria[i]);
					System.out.println("Quantidade em estoque: " + qtdEstoque[i] + "\n");

					encontrado = true;
				}
			}

			if (!encontrado) {
				System.out.println("Produto não encontrado.");
			}

			conferirCAD();
			break;
		}

		// procura produto pelo código
		case 4: {
			boolean encontrado = false;

			System.out.print("Digite o código do produto: ");
			int codprd = sc.nextInt();

			for (int i = 0; i < cod.length; i++) {
				if (cod[i] == codprd) {
					System.out.println("Nome do produto: " + nome[i]);
					System.out.println("Código do produto: " + cod[i]);
					System.out.println("Preço do produto: " + preco[i]);
					System.out.println("Categoria do produto: " + categoria[i]);
					System.out.println("Quantidade em estoque: " + qtdEstoque[i] + "\n");
					encontrado = true;
				}
			}

			if (!encontrado) {
				System.out.println("Produto não encontrado.");
			}

			conferirCAD();
			break;

		}
		// exibe todos os produtos para o usuário
		case 5: {
			boolean encontrado = false;
			if (!encontrado) {
				for (int i = 0; i < nome.length; i++) {
					if (nome[i] != null) {
						System.out.println("Nome do produto: " + nome[i]);
						System.out.println("Código do produto: " + cod[i]);
						System.out.println("Preço do produto: " + preco[i]);
						System.out.println("Categoria do produto: " + categoria[i]);
						System.out.println("Quantidade em estoque: " + qtdEstoque[i] + "\n");
						encontrado = true;
					}
				}
			}
			if (!encontrado) {
				System.out.println("Produto não encontrado.");
			}

			conferirCAD();

			break;
		}
		// cadastra um produto
		case 6: {
			do {
				try {
					System.out.println("Informe o nome do produto:");
					name = sc.nextLine();
					codigo: while (true) {
						System.out.println("Digite o código:");
						codi = sc.nextInt();
						System.out.printf("O código é: %s?\n", codi);
						System.out.println("1 - Sim\n2 - Não");
						int cadINPUT = sc.nextInt();

						switch (cadINPUT) {
						case 1 -> {
							break codigo;
						}
						case 2 -> System.out.println("Digite o código novamente.");
						default -> System.out.println("Escolha 1 ou 2.");
						}
					}

					CATEGORIAS: while (true) {
						System.out.println("Digite a categoria:");
						category = sc.next();
						System.out.printf("A categoria é: %s?\n", category);
						System.out.println("1 - Sim\n2 - Não");
						int cadINPUT = sc.nextInt();

						switch (cadINPUT) {
						case 1 -> {
							break CATEGORIAS;
						}
						case 2 -> System.out.println("Digite a categoria novamente.");
						default -> System.out.println("Escolha 1 ou 2.");
						}
					}
					System.out.println("Informe o preço do produto:");
					precin = sc.nextDouble();

					System.out.println("Digite a quantidade inserida no estoque:");
					estoque = sc.nextInt();

					boolean produtoExistente = false;
					for (int j = 0; j < 1000; j++) {
						if (codi == cod[j]) {
							produtoExistente = true;
							System.err.println("Código já existente, insira novamente.");
							break;
						}
					}

					if (!produtoExistente) {
						for (int i = 0; i < nome.length; i++) {
							if (nome[i] == null) {
								nome[i] = name;
								cod[i] = codi;
								categoria[i] = category;
								preco[i] = precin;
								qtdEstoque[i] = estoque;

								cadastrado = true;
								break;
							}
						}

					}

					do {
						System.out.println("Deseja inserir mais produtos?\n1) Sim\n2) Não");
						encerrar = sc.nextInt();

						if (encerrar == 1) {
							cadastrarProd(6);
						} else if (encerrar == 2) {
							validado();
						} else {
							System.err.println("Opção inválida, insira a opção novamente.");
						}
					} while (true);

				} catch (InputMismatchException e) {
					System.err.println("Código incorreto ou preço com ponto.");
					sc.nextLine();
				}

			} while (true);

		}
		}
	}

	public static void deletarProd() {
		Scanner sc = new Scanner(System.in);
		int codi, decisao;
		boolean encontrado = false;

		System.out.println("Informe o código do produto que deseja deletar:");
		codi = sc.nextInt();

		for (int i = 0; i < cod.length; i++) {
			if (cod[i] == codi) {
				System.out.println("Nome do produto: " + nome[i]);
				System.out.println("Código do produto: " + cod[i]);
				System.out.println("Preço do produto: " + preco[i]);
				System.out.println("Categoria do produto: " + categoria[i]);
				System.out.println("Quantidade em estoque: " + qtdEstoque[i] + "\n");
				encontrado = true;

				System.err.println("Você realmente deseja deletar este produto?\n1) Sim\n2) Não");
				decisao = sc.nextInt();
				if (decisao == 1) {
					nome[i] = null;
					cod[i] = 0;
					preco[i] = 0;
					categoria[i] = null;
					qtdEstoque[i] = 0;

					System.out.println("Produto deletado.");
				}

				else {
					validado();
				}

			}
		}

		if (!encontrado) {
			System.out.println("Produto não encontrado.");
		}
		conferirCAD();
	}

	public static void alterarProd() {
		Scanner sc = new Scanner(System.in);
		boolean encontrado = false;
		int posicao = 0, decisao, opcao;
		String name;

		System.out.print("Digite o código do produto: ");
		int codprd = sc.nextInt();

		for (int i = 0; i < cod.length; i++) {
			if (cod[i] == codprd) {
				System.out.println("Nome do produto: " + nome[i]);
				System.out.println("Código do produto: " + cod[i]);
				System.out.println("Preço do produto: " + preco[i]);
				System.out.println("Categoria do produto: " + categoria[i]);
				System.out.println("Quantidade em estoque: " + qtdEstoque[i] + "\n");

				encontrado = true;
				posicao = i;
				break;
			}

		}

		if (encontrado) {
			System.out.println("Você deseja alterar este produto?\n1) Sim\n2) Não\n3) Voltar");
			decisao = sc.nextInt();

			if (decisao == 1) {
				System.out.println(
						"O que você deseja alterar?\n1) Nome\n2) Código\n3) Preço\n4) Categoria\n5) Quantidade\n6) Tudo");
				opcao = sc.nextInt();
				sc.nextLine(); // Consume newline

				switch (opcao) {
				case 1: {
					System.out.println("Digite o novo nome:");
					nome[posicao] = sc.nextLine();
					break;
				}
				case 2: {
					System.out.println("Digite o novo código:");
					cod[posicao] = sc.nextInt();
					sc.nextLine();
					break;
				}
				case 3: {
					System.out.println("Digite o novo preço:");
					preco[posicao] = sc.nextDouble();
					sc.nextLine();
					break;
				}
				case 4: {
					System.out.println("Digite a nova categoria:");
					categoria[posicao] = sc.nextLine();
					break;
				}
				case 5: {
					System.out.println("Digite a nova quantidade:");
					qtdEstoque[posicao] = sc.nextInt();
					sc.nextLine();
					break;
				}
				case 6: {
					System.out.println("Digite o novo nome:");
					nome[posicao] = sc.nextLine();

					System.out.println("Digite o novo código:");
					cod[posicao] = sc.nextInt();
					sc.nextLine();

					System.out.println("Digite o novo preço:");
					preco[posicao] = sc.nextDouble();
					sc.nextLine();

					System.out.println("Digite a nova categoria:");
					categoria[posicao] = sc.nextLine();

					System.out.println("Digite a nova quantidade:");
					qtdEstoque[posicao] = sc.nextInt();
					sc.nextLine();
					break;
				}
				default: {
					System.out.println("Opção inválida.");
					break;
				}
				}

				System.out.println("Produto atualizado com sucesso!");

			} else if (decisao == 2) {
				System.out.println("Nenhuma alteração realizada.");
				validado();

			} else if (decisao == 3) {
				System.out.println("Operação cancelada.");

			} else {
				System.out.println("Opção inválida.");
			}
		} else {
			System.out.println("Produto não encontrado.");
		}

		conferirCAD();

	}

	public static void validado() {
		Scanner sc = new Scanner(System.in);

		// validado
		System.out.println("\n**BEM-VINDO**");
		System.out.println(
				"1) Conferir cadastrados\n2) Deletar Produtos\n3) Cadastrar Produto\n4) Alterar Produto\n5) Encerrar programa");
		int input = sc.nextInt();

		switch (input) {

		case 1:
			conferirCAD();
			break;

		case 2:
			deletarProd();
			break;

		case 3:
			cadastrarProd(6);
			break;

		case 4:
			alterarProd();
			break;
		case 5:
			System.exit(0);
		}
	}

	public static void conferirCAD() {
		/*
		 * Todos os cadastrados
		 */
		Scanner sc = new Scanner(System.in);
		int voltar, inputCAD;

		System.out.println(
				"***CONFERIR CADASTRADOS***\nSelecione a categoria desejada\n1 - Limpeza\n2 - Frutas\n3 - Mercearia\n4 - Inserir Código\n5 - Exibir Todos os Produtos\n6 - Voltar");
		inputCAD = sc.nextInt();

		switch (inputCAD) {

		case 1:
			// limpeza
			cadastrarProd(1);
			break;

		case 2:
			// frutas
			cadastrarProd(2);
			break;

		case 3:
			// mercearia
			cadastrarProd(3);
			break;

		case 4:
			// procurar produto por código
			cadastrarProd(4);
			break;

		case 5:
			// exibir todos os produtos
			cadastrarProd(5);
			break;

		case 6:
			validado();
			break;

		default:
			System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
		}
		// finaliza o programa
		do {
			System.out.println("\nPressione 1 para voltar, 0 para encerrar");
			voltar = sc.nextInt();
		} while (voltar != 1 && voltar != 0);

		if (voltar == 1) {
			conferirCAD();
		} else {
			System.exit(0);
		}
	}

	public static void main(String[] args) {

		// LOGIN
		String user, senha;

		Scanner sc = new Scanner(System.in);

		System.out.println("***SISTEMA DE SUPERMERCADO***");

		do {
			System.out.println("Usuário:");
			user = sc.nextLine();

			System.out.println("Senha:");
			senha = sc.nextLine();

			if (!user.equals("admin") || !senha.equals("123")) {
				System.err.println("Usuário ou senha incorretos.");
			} else {
				break;
			}
		} while (true);

		validado();
	}

}
