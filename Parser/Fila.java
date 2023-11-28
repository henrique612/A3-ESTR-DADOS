package Parser;


public class Fila {
    private String idFila;
    private Pessoa pessoa;
    private Fila proximaFila;

    public Fila(){
        this.idFila=null;
        this.pessoa=null;
        this.proximaFila=null;
    }

    public Fila(String id){
        this.idFila=id;
        this.pessoa=null;
        this.proximaFila=null;
    }

    public void addFila(String id){
        if(this.idFila==null){
            this.idFila = id;
        }else if(this.proximaFila!=null){
            this.proximaFila.addFila(id);
        }else{
            this.proximaFila = new Fila(id);
        }
    }

    
    public void addNewPessoa(Grupos grupos,String pessoa){
        Position initialPosition = new Position(this.idFila, 0);
        initialPosition = this.findBestPlace(grupos, pessoa, initialPosition);
        
    }

    public Position findBestPlace(Grupos grupos,String pessoa, Position currentPosition){
            Position bestPosition = new Position(currentPosition);
            currentPosition.setFila(this.idFila);
            currentPosition.setPlaceNumber(0);
            if(this.pessoa != null) {  
                if (this.pessoa.getProximo() != null)  {
                    Pessoa aux = this.pessoa;
                    while (currentPosition.checkPlace() ) {
                        currentPosition.increase();
                        if(aux.getProximo() != null) {
                            if (grupos.conhece(aux.getNome(), pessoa ) && !grupos.conhece(aux.getProximo().getNome(), pessoa)){
                                if(currentPosition.checkPlace()){
                                    currentPosition.setLimit();
                                }
                                break;
                            }else{
                                aux = aux.getProximo();
                            }
                        }else{
                           // currentPosition.increase();
                            break;
                        }
                    }
                }else{
                    currentPosition.increase();
                }
            }
            if(currentPosition.getPlaceNumber() <= bestPosition.getPlaceNumber() || currentPosition.getFila() == bestPosition.getFila()){
                bestPosition = currentPosition;
            }
            if(this.proximaFila != null){
                bestPosition = this.proximaFila.findBestPlace(grupos, pessoa, bestPosition);
            }
            
            if(bestPosition.getFila() == this.idFila){
                if(this.pessoa == null) {
                    this.pessoa = new Pessoa(pessoa);
                }else{
                    this.pessoa.addProximo(pessoa, bestPosition.getPlaceNumber());
                }
            }
            return bestPosition;
    }

    public void atendeFila(String idFila){
        if(this.idFila.equalsIgnoreCase(idFila)){
            this.pessoa = this.pessoa.getProximo();
        }else if(this.proximaFila != null){
            this.proximaFila.atendeFila(idFila);
        }else{
            System.out.println("Fila não encontrada.");
        }
    }

    public void desiste(String nome){
        boolean desistiu = false;
        if (this.pessoa !=null){
            desistiu =  this.pessoa.desiste(nome);
        }if(!desistiu && this.proximaFila != null ){
            this.proximaFila.desiste(nome);
        }
    }

    public void print(){
        String lista = "#" + this.idFila + "[";
        Pessoa aux = this.pessoa;
        while (aux != null) {
            lista = lista + " "+ aux.getNome();
            if(aux.getProximo()!=null){
                lista = lista + ",";
            }
            aux = aux.getProximo();
        }
        lista = lista + " ]";
        System.out.println(lista);
        if(this.proximaFila!=null){
            this.proximaFila.print();
        }
    }
}
