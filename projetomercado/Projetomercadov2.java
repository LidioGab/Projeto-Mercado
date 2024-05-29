	package projetomercado;
	
	import java.util.*;
	
	public class Projetomercadov2 {
		
		static int contador = 0, encerrar;
		static String[] nome = new String[1000];
		static double [] preco = new double[1000];
		static int [] cod = new int[1000];
		static String [] categoria = new String[1000];
		
		public static void cadastrarProd(int codigo) {
			Scanner sc = new Scanner(System.in);
			
			int codi;
			String name, category;
			double precin;
			
			switch(codigo) {
			
				case 1:{
					boolean encontrado = false;
					
					for(int i = 0; i < cod.length; i++) {
	                	if(categoria[i] != null && categoria[i].equalsIgnoreCase("limpeza")) {
	                		System.out.println("Nome do produto: " + nome[i]);
	                		System.out.println("Codigo do produto: " + cod[i]);
	                		System.out.println("Preco do produto: " + preco[i]);
	                		System.out.println("Categoria do produto: " + categoria[i] + "\n");
	                		
	                		encontrado = true;
	                		
	                	}
	                	
	          
					}
					
					if(!encontrado) {
						System.out.println("Produto nao encontrado");
					}
					conferirCAD();
					break;
				}
				
				case 2:{
					boolean encontrado = false;
					
					for(int i = 0; i < cod.length; i++) {
	                	if(categoria[i] != null && categoria[i].equalsIgnoreCase("frutas")) {
	                		System.out.println("Nome do produto: " + nome[i]);
	                		System.out.println("Codigo do produto: " + cod[i]);
	                		System.out.println("Preco do produto: " + preco[i]);
	                		System.out.println("Categoria do produto: " + categoria[i] + "\n");   
	                		
	                		
	                		encontrado = true;
	                	}
	                	
	                	
					}
					if(!encontrado) {
						System.out.println("Produto nao encontrado");
					}
					
					conferirCAD();
					break;
					
				}
				
				case 3:{
					boolean encontrado = false;
					for(int i = 0; i < cod.length; i++) {
	                	if(categoria[i] != null && categoria[i].equalsIgnoreCase("mercearia")) {
	                		System.out.println("Nome do produto: " + nome[i]);
	                		System.out.println("Codigo do produto: " + cod[i]);
	                		System.out.println("Preco do produto: " + preco[i]);
	                		System.out.println("Categoria do produto: " + categoria[i]+ "\n");
	                		
	                		encontrado = true;
	                		
	                	} 
					}
					
					if(!encontrado) {
						System.out.println("Produto nao encontrado");
					}
					
					
					conferirCAD();
					break;
				}
					
					//procura produto pelo codigo
					case 4:{
					     	boolean encontrado = false;
	
			                System.out.print("Digite o código do produto: ");
			                int codprd = sc.nextInt();
			                
			                
			                for(int i = 0; i < cod.length; i++) {
			                	if(cod[i] == codprd) {
			                		System.out.println("Nome do produto: " + nome[i]);
			                		System.out.println("Codigo do produto: " + cod[i]);
			                		System.out.println("Preco do produto: " + preco[i]);
			                		System.out.println("Categoria do produto: " + categoria[i] + "\n");
			                		encontrado = true;
			                		
			                	}
			                }
			                	
	
			                if (!encontrado) {
			                    System.out.println("Produto não encontrado.");
			                }
			                conferirCAD();
			                break;
			                
					}	
					//exibe todos os produtos para o usuario
					case 5:{
						if (contador == 0) {
							System.err.println("Nao existe produtos cadastrados");
						}else {
							for(int i = 0; i < contador; i++) {
								System.out.println("Nome do produto: " + nome[i]);
		                		System.out.println("Codigo do produto: " + cod[i]);
		                		System.out.println("Preco do produto: " + preco[i] );
		                		System.out.println("Categoria do produto: " + categoria[i] + "\n");
							}
						}
						
						break;
					}
					//cadastra um produto
					case 6:{
						do {
							try {		
								System.out.println("Informe o nome do produto");
								name = sc.nextLine();
								codigo:
			                        while (true) {
			                            System.out.println("Digite o codigo:");
			                            codi = sc.nextInt();
			                            System.out.printf("o codigo é: %s?\n", codi);
			                            System.out.println("1 - Sim\n2 - Não");
			                            int cadINPUT = sc.nextInt();
	
			                            switch (cadINPUT) {
			                                case 1 -> {
			                                    break codigo;
			                                }
			                                case 2 -> 
			                                    System.out.println("Digite o codigo novamente.");
			                                default -> System.out.println("Escolha 1 ou 2.");
			                            }
			                        }
								
								CATEGORIAS:
			                        while (true) {
			                            System.out.println("Digite a categoria:");
			                            category = sc.next();
			                            System.out.printf("A categoria é: %s?\n", category);
			                            System.out.println("1 - Sim\n2 - Não");
			                            int cadINPUT = sc.nextInt();
	
			                            switch (cadINPUT) {
			                                case 1 -> {
			                                    break CATEGORIAS;
			                                }
			                                case 2 -> 
			                                    System.out.println("Digite a categoria novamente.");
			                                default -> System.out.println("Escolha 1 ou 2.");
			                            }
			                        }
								System.out.println("Informe o preço do produto");
								precin = sc.nextDouble();
								
								
								boolean produtoExistente = false;
								for(int j = 0; j < 1000; j++) {
									if(codi == cod[j]) {
										produtoExistente = true;
										System.err.println("nome ou codigo ja existente, insira novamente");
										break;
									}
									
								}
								
								if(!produtoExistente){
									nome[contador] = name;
									cod[contador] = codi;
									categoria[contador] = category;
									preco[contador] = precin;	
									contador++;
								}
								
								System.out.println("Deseja inserir mais produtos ?\n1) Sim\n2) Não");
								encerrar = sc.nextInt();
								
								
								
								if(encerrar == 2) {
									validado();
								}
								else {
									cadastrarProd(6);
									break;
								}
								
							}catch(InputMismatchException e) {
								System.err.println("Codigo incorreto ou preco com ponto");
								sc.nextLine();
							}
							
						}while(true);	
					
					}
			}
		}
	
	    public static void validado(){
	     Scanner sc = new Scanner(System.in);
	        
	        //validado
	        System.out.println("\n**BEM-VINDO**");
	        System.out.println("1) Conferir cadastrados\n2) Selecionar Itens\n3) Cadastrar Produto\n4) Encerrar programas");
	        int input = sc.nextInt();
	
	        switch (input) {
	
	            case 1:
	                conferirCAD();
	                break;
	
	            case 2:
	
	                break;
	
	            case 3:
	            	cadastrarProd(6);
	            	break;
	        }
	    }
	    
	    public static void conferirCAD() {
	        /*
	        Todos os cadastrados
	         */
	        Scanner sc = new Scanner(System.in);
	        int voltar, inputCAD;
	      
	       
	        System.out.println("***CONFERIR CADASTRADOS***\nSelecione a categoria desejada\n1 - Limpeza\n2 - Frutas\n3 - Mercearia\n4 - Inserir Código\n5 - Exibir Todos os Produtos\n6 - Voltar");
	        inputCAD = sc.nextInt();
	
	        switch (inputCAD) {
	
	            case 1:
	                //limpeza
	            	cadastrarProd(1);
	
	                break;
	
	            case 2:
	                //frutas
	
	            	cadastrarProd(2);
	
	            case 3:
	                //mercearia
	            	cadastrarProd(3);
	
	                break;
	
	            case 4:
	                //PROCURAR PRODUTO POR CÓDIGO
	            	cadastrarProd(4);
	            	
	            case 5:
	            	cadastrarProd(5);
	           
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
