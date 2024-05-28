package projetomercado;

import java.util.*;

public class Projetomercadov2 {
	
	static int contador = 0, encerrar;
	static String[] nome = new String[1000];
	static double [] preco = new double[1000];
	static int [] cod = new int[1000];
	
	public static void cadastrarProd(int codigo) {
		Scanner sc = new Scanner(System.in);
	
		
		switch(codigo) {
			case 3:
				//cadastra um produto
				do {
					try {		
						System.out.println("Informe o nome do produto");
						nome[contador] = sc.nextLine();
						System.out.println("Informe o codigo do produto");
						cod[contador] = sc.nextInt();
						System.out.println("Informe o preço do produto");
						preco[contador] = sc.nextDouble();
						
						System.out.println("Deseja inserir mais produtos ?\n1) Sim\n2) Não");
						encerrar = sc.nextInt();
						
						contador++;
						
						if(encerrar == 2) {
							validado();
						}
						else {
							continue;
						}
					}catch(InputMismatchException e) {
						System.err.println("Codigo incorreto ou preco com ponto");
						sc.nextLine();
					}
					
				}while(true);	
				//procura produto
				case 4:{
				     	boolean encontrado = false;

		                System.out.print("Digite o código do produto: ");
		                int codprd = sc.nextInt();
		                

		                for(int i = 0; i < cod.length; i++) {
		                	if(cod[i] == codprd) {
		                		System.out.println("Nome do produto: " + nome[i]);
		                		System.out.println("Codigo do produto: " + cod[i]);
		                		System.out.println("Preco do produto: " + preco[i]);
		                		
		                		encontrado = true;
		                		break;
		                	}
		                }

		                if (!encontrado) {
		                    System.out.println("Produto não encontrado.");
		                }
		                break;
				}	
			
		}
		
		
	}

    public static void validado(){
     Scanner sc = new Scanner(System.in);
        
        //validado
        System.out.println("**BEM-VINDO**");
        System.out.println("1) Conferir cadastrados\n2) Selecionar Itens\n3) Cadastrar Produto\n4) Encerrar programas");
        int input = sc.nextInt();

        switch (input) {

            case 1:
                conferirCAD();
                break;

            case 2:

                break;

            case 3:
            	cadastrarProd(input);
            	break;

        }
    }
    
    public static void conferirCAD() {

        /*
        Todos os cadastrados
         */
        Scanner sc = new Scanner(System.in);
        int voltar, inputCAD;
        String[][] codProd = {
                {"000", "001", "002", "003", "004"}, // LIMPEZA
                {"005", "006", "007", "008", "009"}, // FRUTAS
                {"010", "011", "012", "013", "014"} // MERCEARIA
        };

        String[][] categorias = {
                {"Sabão em pó", "Desinfetante", "Amaciante de Roupas", "Detergente", "Água Sanitária"},
                {"Banana", "Maçã", "Uva", "Morango", "Laranja"},
                {"Arroz", "Feijão", "Óleo de cozinha", "Macarrão", "Molho de tomate"}
        };

        int[][] precos = {
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5}
        };

        System.out.println("***CONFERIR CADASTRADOS***\nSelecione a categoria desejada\n1 - Limpeza\n2 - Frutas\n3 - Mercearia\n4 - Inserir Código\n5 - Exibir Todos os Produtos\n6 - Voltar");
        inputCAD = sc.nextInt();

        switch (inputCAD) {

            case 1:
                //limpeza
                System.out.println(Arrays.toString(categorias[0]));
                System.out.println(Arrays.toString(codProd[0]));

                break;

            case 2:
                //frutas

                System.out.println(Arrays.toString(categorias[1]));
                System.out.println(Arrays.toString(codProd[1]));

            case 3:
                //mercearia
                System.out.println(Arrays.toString(categorias[2]));
                System.out.println(Arrays.toString(codProd[2]));

                break;

            case 4:
                //PROCURAR PRODUTO POR CÓDIGO
            	cadastrarProd(4);
           
            case 6:

                validado();
                break;

            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }
        //finaliza o programa
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

//LOGIN
        String user, senha;

        Scanner sc = new Scanner(System.in);

        System.out.println("***SISTEMA DE SUPERMERCADO***");

        do {
            System.out.println("Usuário:");
            user = sc.nextLine();

            System.out.println("Senha:");
            senha = sc.nextLine();
            
            if(!user.equals("admin") || !senha.equals("123")) {
            	System.err.println("Usuario ou senha incorretos");
            }
            else {
            	break;
            }
        } while (true);

        validado();
    }
   
}
