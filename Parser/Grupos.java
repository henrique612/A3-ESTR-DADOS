package Parser;

public class Grupos {

	private Pessoa raiz;
	private Grupos proximoGrupo;


    public Grupos(){
        this.raiz = null;
        this.proximoGrupo = null;
    }
	
    public void adicionar(String nome){
        adicionar(raiz, nome);
    }

	private void adicionar(Pessoa raiz, String nome) {
        if(raiz !=null){
            if (nome.compareToIgnoreCase(raiz.getNome() ) < 0) {
                // ESQUERDA
                if (raiz.getAnterior() == null) {
                    raiz.setAnterior(new Pessoa(nome));
                } else {
                    adicionar(raiz.getAnterior(), nome);
                }
            } else if (nome.compareToIgnoreCase(raiz.getNome() ) > 0) {
                // Direta
                if (raiz.getProximo() == null) {
                    raiz.setProximo(new Pessoa(nome));
                } else {
                    adicionar(raiz.getProximo(), nome );
                }
            }
        }else{
            this.raiz = new Pessoa(nome);
        }
    }
	
	private Boolean buscaPessoa(Pessoa raiz, String valor) {
        if(raiz != null) {
            if(raiz.getNome().equalsIgnoreCase(valor)) {
                return true;
            } else {
                if(valor.compareToIgnoreCase(raiz.getNome() ) < 0) {
                    return buscaPessoa(raiz.getAnterior(), valor);
                } else {
                    return buscaPessoa(raiz.getProximo(), valor);
                }
            }
        } 
        return false;
    }
	
	public Boolean existe(String nome) {
		if (buscaPessoa(raiz, nome)){
			return true;
        }else if (this.proximoGrupo !=null) {
            this.proximoGrupo.existe(nome);
		}
        return false;

	}
	
	public boolean conhece(String primeiroNome, String segundoNome) {
		if(buscaPessoa(raiz, primeiroNome) &&  buscaPessoa(raiz, segundoNome)) {
			return true;
        }else if (this.proximoGrupo !=null){
            return this.proximoGrupo.conhece(primeiroNome, segundoNome);
		}else {
			return false;
		}
	}
	
    public void addGrupo(Grupos newGrupo){
            if(this.raiz == null){
                this.raiz=newGrupo.getRaiz();
            }
            else if(this.proximoGrupo != null){
                this.proximoGrupo.addGrupo(newGrupo);
            }else{
                this.proximoGrupo = newGrupo;
            }
    }

    public Pessoa getRaiz(){
        return this.raiz;
    }

}
