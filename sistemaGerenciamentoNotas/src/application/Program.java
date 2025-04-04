package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import entities.Notas;


public class Program {

	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	Notas notas = new Notas();
	
	int option;
	
	do{
		System.out.println("\n⧫ Seja bem-vindo ao Sistema de Gerenciamento de Notas⧫");
		System.out.println("Escolha uma opção\n\n"
			+ "1 - Cadastrar Aluno\n"
			+ "2 - Listar Alunos\n"
			+ "3 - Sair\n");
		
		option = sc.nextInt();	
		
		switch (option) {
		case 1 : 
			System.out.print("Informe o nome do aluno:  ");
			sc.nextLine();
			String nome1 = sc.nextLine();
			
			System.out.println("Quantas notas deseja inserir? ");
			int num = sc.nextInt();
			
			for(int i = 1; i <= num; i++) {
				
				System.out.println("Digite a nota "+i+":");
				double nota = sc.nextDouble();
				notas.cadastrarNota(nota);
			}
			notas.calcularMedia();
			
			Aluno aluno = new Aluno(nome1, notas);
			
		break;
		case 2:
			Aluno.imprimirTodosAlunos();
		break;
		
		default:
			System.out.println("Opção Inválida! Digite novamente");
		}
		
	}while(option != 3);
		
	 System.out.println("🚀 Programa encerrado! Obrigado por usar o sistema!");
	}

}
