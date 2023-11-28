package Parser;


public class Pessoa {
	private Pessoa proximo;
	private Pessoa anterior;
	private String nome ;
	
	public Pessoa(String nome) {
		this.nome = nome;
		this.anterior = null;
		this.proximo = null;
	}
	
	public Pessoa(String nome, Pessoa proximo) {
		this.nome = nome;
		this.anterior = null;
		this.proximo = proximo;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setProximo(Pessoa proximo) {
		this.proximo = proximo;
	}
	public void setAnterior(Pessoa anterior) {
		this.anterior = anterior;
	}
	
	public Pessoa getProximo() {
		return this.proximo;
	}
	public Pessoa getAnterior() {
		return this.anterior;
	}

	public void addProximo(String novaPessoa , Integer distancia){
		if(distancia == 0){
			Pessoa aux = new Pessoa(this.nome, this.proximo);
			this.nome = novaPessoa;
			this.proximo = aux;
		}
		else if (this.proximo == null){
			this.proximo = new Pessoa(novaPessoa);
		}
		else{
			this.proximo.addProximo(novaPessoa, distancia -1);
		}
	}

	public boolean desiste(String nome){
		Pessoa aux = this.proximo;
		if(aux != null){
		if(this.nome.equalsIgnoreCase(nome) ){
			this.nome = aux.getNome();
			this.proximo = aux.proximo;
			return true;
		}else if(aux.getNome().equalsIgnoreCase(nome)){
			this.proximo = aux.getProximo();
			return true;
		}else {
			return this.proximo.desiste(nome);
		}
		}else{
			return false;
		}	
		
	}
}
