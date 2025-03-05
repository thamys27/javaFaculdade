package entities;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	//Classe responsável por cadastrar os Alunos
	private String nome;
	private Notas notas;
	
	private static List<Aluno> listarAlunos = new ArrayList<>();

	
	public Aluno() {}

	public Aluno(String nome, Notas notas) {
		super();
		this.nome = nome;
		this.notas = notas;
		
		listarAlunos.add(this);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Notas getNotas() {
		return notas;
	}

	public void setNotas(Notas notas) {
		this.notas = notas;
	}

	public void adicionarNota (double nota) {
		notas.cadastrarNota(nota);
	}
	
	public static void imprimirTodosAlunos() {
        for (Aluno aluno : listarAlunos) {
            System.out.println(aluno);}
        }
	@Override
	public String toString() {
	    return String.format("🔹 %s - Média: %.2f - %s", 
	                          nome, 
	                          notas.calcularMedia(), 
	                          notas.getStatus());
	}

	
}
