package Parser;

public class Position {
    private String fila;
    private Integer placeNumber;
    private Integer limit;

    public Position(String fila, Integer position){
        this.fila= fila;
        this.placeNumber = position;
    }

    public Position(Position position ){
        this.fila = position.getFila();
        this.placeNumber = position.getPlaceNumber();
        this.limit = position.getLimit();
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public Integer getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(Integer placeNumber) {
        this.placeNumber = placeNumber;
    }

    public Integer getLimit(){
        return this.limit;
    }

    public void setLimit(){
        this.limit = placeNumber;
    }
    

    public boolean checkPlace(){
        if (this.limit ==null){
            return true;
        }else if (this.placeNumber < this.limit) {
            return true;
        } else {
            this.placeNumber++;
            return false;
        }
    }

    public void increase(){
        this.placeNumber++;
    }

    public void decrease(){
        this.placeNumber--;
    }
}
