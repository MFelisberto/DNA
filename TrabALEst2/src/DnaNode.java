public class DnaNode{

    // CLASSE NODO
    private char dna;
    private DnaNode prev;
    private DnaNode next;
    
    public DnaNode(char dna, DnaNode prev, DnaNode next){
        this.dna = dna;
        this.prev = prev;
        this.next = next;
    }
    public DnaNode(DnaNode prev, DnaNode next){ //CONSTRUTOR SEM DNA PARA FAZER OS SENTINELAS
        this.prev = prev;
        this.next = next;
    }

    // GETTERS E SETTERS
    public char getDna() {
        return dna;
    }
    public void setDna(char dna) {
        this.dna = dna;
    }
    public DnaNode getPrev() {
        return prev;
    }
    public void setPrev(DnaNode prev) {
        this.prev = prev;
    }
    public DnaNode getNext() {
        return next;
    }
    public void setNext(DnaNode next) {
        this.next = next;
    }
}
