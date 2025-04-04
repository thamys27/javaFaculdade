package entities;

public class Hamburguer extends Produto {
    private String comQueijo;
    private String comSalada;
    private String doubleCarne;

    
    public Hamburguer(int id, String nome, double preco, String comQueijo, String comSalada, String doubleCarne) {
		super(id, nome, preco);
		this.comQueijo = comQueijo;
		this.comSalada = comSalada;
		this.doubleCarne = doubleCarne;
	}

	public String getComQueijo() {
        return comQueijo;
    }

    public void setComQueijo(String comQueijo) {
        this.comQueijo = comQueijo;
    }

    public String getComSalada() {
        return comSalada;
    }

    public void setComSalada(String comSalada) {
        this.comSalada = comSalada;
    }

    public String getDoubleCarne() {
        return doubleCarne;
    }

    public void setDoubleCarne(String doubleCarne) {
        this.doubleCarne = doubleCarne;
    }

    @Override
    public String exibirProduto() {
        return super.exibirProduto() + 
               "\n -> Queijo: " + (comQueijo.equalsIgnoreCase("S") ? "Sim" : "Não") +
               "\n -> Salada: " + (comSalada.equalsIgnoreCase("S") ? "Sim" : "Não") +
               "\n -> Carne extra: " + (doubleCarne.equalsIgnoreCase("S") ? "Sim" : "Não");
    }
}
