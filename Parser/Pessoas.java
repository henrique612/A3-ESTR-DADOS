package Parser;

public class Pessoas {
    String nome;
    String fila;
    Pessoas proximaFila;
    Pessoas proximo;

    public Pessoas(){
        this.nome = null;
        this.fila = null;
        this.proximaFila = null;
        this.proximo = null;
    }

    public Pessoas(String fila){
        this.fila = fila;
        this.proximaFila = null;
        this.nome = null;
        this.proximo = null;

    }

    public Pessoas(String nome, String fila){
        this.fila = fila;
        this.nome = nome;
    }

    public Pessoas(Pessoas original){
        this.fila = original.getFila();
        this.nome = original.getNome();
        this.proximaFila = original.getProximaFila();
        this.proximo = original.getProximo();
    }

    public void addFila(String fila){
        if(this.fila == null){
            this.fila = fila;
        }else if(this.proximaFila !=null){
            this.proximaFila.addFila(fila);
        }else{
            this.proximaFila = new Pessoas(fila);
        }
    }

    public void addProximaPessoa(String novaPessoa , Integer distancia,String fila){
        if(this.fila == fila){
        if(this.nome == null){
            this.nome = novaPessoa;
        }
        else if (this.proximo == null){
			this.proximo = new Pessoas(novaPessoa, this.fila);
		}
		else if(distancia == 0){
			Pessoas aux = new Pessoas(this);
			this.nome = novaPessoa;
			this.proximo = aux;
		}else{
			this.proximo.addProximaPessoa(novaPessoa, distancia -1,fila);
        }		
        }else if(this.proximaFila != null){
            this.proximaFila.addProximaPessoa(novaPessoa, distancia, fila);
        }

    }

    public void addPessoaFila(Grupos base , String nome){
        Position bestPosition =  addNewPessoa(base, nome, null);
        this.addProximaPessoa(nome,bestPosition.getPlaceNumber(),bestPosition.getFila());
    }

    public Position addNewPessoa(Grupos base , String nome, Position bestPosition ){
        if(bestPosition == null){
                bestPosition = new Position(this.fila, 0);
        }
        if(this.nome == null ){
            bestPosition.setPlaceNumber(0);
            if(bestPosition.checkPlace()){
                bestPosition.setLimit();
                bestPosition.setFila(this.fila);
            if(this.proximaFila!=null) {
                bestPosition = this.proximaFila.addNewPessoa(base, nome, bestPosition);
            }
        }
        }else if(this.proximo !=null){
            if(base.conhece(this.nome, nome) && !base.conhece(this.proximo.getNome(), nome)){
                bestPosition.increase();
                if(bestPosition.checkPlace()){
                    bestPosition.setLimit();
                    bestPosition.setFila(this.fila);
                    if(this.proximaFila!=null) {
                        bestPosition = this.proximaFila.addNewPessoa(base, nome, bestPosition);
                    }
                }else{
                    bestPosition = this.proximo.addNewPessoa(base, nome, bestPosition);
                }
            }
        }
        else if(this.proximo == null){
            bestPosition.increase();
            if(bestPosition.checkPlace()){
                bestPosition.setLimit();
                bestPosition.setFila(this.fila);
                if(this.proximaFila!=null) {
                    bestPosition = this.proximaFila.addNewPessoa(base, nome, bestPosition);
                }
            }
        }else if(this.proximaFila!=null) {
                    bestPosition = this.proximaFila.addNewPessoa(base, nome, bestPosition);
        } else{
            bestPosition.increase();
            if(bestPosition.checkPlace()){
                bestPosition.setLimit();
                bestPosition.setFila(this.fila);
                if(this.proximaFila!=null) {
                    bestPosition = this.proximaFila.addNewPessoa(base, nome, bestPosition);
                }
            }
        }
        return bestPosition;
    }

    public void desiste(String nome){
        Pessoas aux = this.proximo;
		if(aux != null){
		    if(this.nome.equalsIgnoreCase(nome) ){
		    	this.nome = aux.getNome();
		    	this.proximo = aux.proximo;
		    }else if(aux.getNome().equalsIgnoreCase(nome)){
		    	this.proximo = aux.getProximo();
		    }else {
		    	this.proximo.desiste(nome);
		    }
		}else if (this.proximaFila !=null){
			this.proximaFila.desiste(nome);
		}else{
            System.out.println("Ninguem desistiu");
        }
    }

        public void atendeFila(String idFila){
            Pessoas aux = this.proximo;
		    if(aux != null){
            if(this.fila.equalsIgnoreCase(idFila)){
                this.nome = aux.getNome();
                this.proximo = aux.getProximo();
            }else if(this.proximaFila != null){
                this.proximaFila.atendeFila(idFila);
            }else{
                System.out.println("Fila não encontrada.");
            }
        }
    }
    



    public String getFila(){
        return this.fila;
    }

    public void setFila(String fila){
        this.fila = fila;
    }
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome ){
        this.nome = nome;
    }

    public Pessoas getProximaFila(){
        return this.proximaFila;
    }

    public void setProximaFila(Pessoas proximaFila){
        this.proximaFila = proximaFila ;
    }

    public Pessoas getProximo(){
        return this.proximo;
    }

    public void setProximo(Pessoas proximo){
        this.proximo = proximo;
    }
}
