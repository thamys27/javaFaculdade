package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import entities.Hamburguer;

public class McRomes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        double totalPedido = 0;

        List<Hamburguer> pedidos = new ArrayList<>();

        do {
            System.out.println("\n--------Seja Bem-Vindo ao Sistema de Atendimento----------");
            System.out.println("--------🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔MC ROMES🍔🍔🍔🍔🍔🍔🍔🍔----------");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Exibir Cardápio");
            System.out.println("2 - Realizar um pedido");
            System.out.println("3 - Sair");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                	
                    System.out.println("1 - Big Romes - R$ 15.00");
                    System.out.println("2 - Cheddar Romes - R$ 18.00");
                    System.out.println("3 - Romes Chicken - R$ 12.00");
                    break;

                case 2:
                	
                	//bloco try/catch para entradas que não são números
                	try {
                    System.out.print("Escolha o número do hambúrguer: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    String nome = switch (id) {
                        case 1 -> "Big Romes";
                        case 2 -> "Cheddar Romes";
                        case 3 -> "Romes Chicken";
                        default -> {
                            System.out.println("Opção inválida!");
                            continue;
                        }
                    };

                    double preco = switch (id) {
                        case 1 -> 15.00;
                        case 2 -> 18.00;
                        case 3 -> 12.00;
                        default -> 0.0;
                    };
                	
                	
                    System.out.print("Adicionar queijo? R$2 (S/N): ");
                    String queijo = sc.nextLine();

                    System.out.print("Adicionar salada? R$2 (S/N): ");
                    String salada = sc.nextLine();

                    System.out.print("Adicionar carne extra? R$6 (S/N): ");
                    String carne = sc.nextLine();

                    if (queijo.equalsIgnoreCase("s")) preco += 2;
                    if (salada.equalsIgnoreCase("s")) preco += 2;
                    if (carne.equalsIgnoreCase("s")) preco += 6;

                    Hamburguer pedido = new Hamburguer(id, nome, preco, queijo, salada, carne);

                    pedidos.add(pedido); 
                    totalPedido += pedido.getPreco();
                    System.out.println("✅ Pedido adicionado com sucesso!");
                    break;
                    
                	} 
                	
                	catch (NumberFormatException e) {
						System.out.println("Eita! Não existe essa opção no cardápio :( ");
						sc.nextLine();
					} catch (InputMismatchException e) {
						System.out.println("Entrada Inválida! Por favor, insira a informação"
								+ "no formato esperado");	
						} catch (ArithmeticException e) {
							System.out.println("Erro de cálculo! Verifique se os valores"
									+ "informados são maiores que ZERO");
						} catch (NullPointerException e) {
							System.out.println("Falha do Sistema! :("
									+ "\n Tente Novamente");
						} catch(IndexOutOfBoundsException e) {
							System.out.println("Eita! Não existe essa opção no cardápio, verifique"
									+ "o número do seu lanche novamente");
						}
                case 3:
                    System.out.println("\n📝 Lista de pedidos realizados:");
                    for (Hamburguer p : pedidos) {
                        System.out.println(p.exibirProduto());
                        System.out.println("------------------------------");
                    }

                    System.out.printf("💰 Total final do pedido: R$ %.2f%n", totalPedido);
                    System.out.println("Obrigado por comprar no MC Romes! 🍔😄");
                    break;

                default:
                    System.out.println("Opção errada, tente novamente.");
            }
        } while (option != 3);

        sc.close();
    }
}
