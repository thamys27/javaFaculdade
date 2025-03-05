package entities;

import java.util.ArrayList;
import java.util.List;

import enums.StatusAluno;

public class Notas {

	//Classe responsável  pelas notas 
	
	private List<Double> listarNotas = new ArrayList<>();
	
	public Notas() {}

	public List<Double> getListarNotas() {
		return listarNotas;
	}

	public void setListarNotas(List<Double> listarNotas) {
		this.listarNotas = listarNotas;
	}

	public Notas(List<Double> listarNotas) {
		super();
		this.listarNotas = listarNotas;
	}
	
	//Método para Cadastrar notas
	public void cadastrarNota(double nota) {
		listarNotas.add(nota);
	}
	
	//Método para Média
	public double calcularMedia() {
		
		double soma = 0;
		for (double nota : listarNotas) {
			soma += nota;
		}
		return soma/listarNotas.size();
	}
	
	public StatusAluno getStatus() {
	    double media = calcularMedia();

	    if (media >= 7) {
	        return StatusAluno.APROVADO;
	    } else if (media >= 5) {
	        return StatusAluno.RECUPERACAO;
	    } else {
	        return StatusAluno.REPROVADO;
	    }
	}

}
