import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DoubleDnaList{
    
    // CLASSE DOUBLE DNA LIST
    private DnaNode header;
    private DnaNode trailer;
    private int size;

    public DoubleDnaList(){ // AUTOMATICAMENTE CRIAR OS SENTINELAS
        header = new DnaNode(null, null);
        trailer = new DnaNode(header, null);
        header.setNext(trailer); //QUANDO VC CRIA A LISTA ELA ESTA VAZIA.. ENTAO  O HEADER.NEXT = TRAILER
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    public char frist(){
        if(isEmpty()){
            return '0';
        }

        return header.getNext().getDna();
    }

    public char last(){
        if(isEmpty()){
            return '0';
        }

        return trailer.getPrev().getDna();
    }

    public void addFirst(char dna){
        addBetween(dna, header, header.getNext());
    }

    public void add(char dna){
        if(isEmpty()){
            addBetween(dna, header, header.getNext());
        }else{
            addBetween(dna, trailer.getPrev(), trailer);
        }
    }

    private void addBetween(char dna,DnaNode prev, DnaNode next){
       
        if(dna == 'D' || dna == 'N' || dna == 'A'){
            DnaNode newNode = new DnaNode(dna,prev,next);
            prev.setNext(newNode);
            next.setPrev(newNode);
            size++;
       }
    }

    public char removeFirst(){
        if(isEmpty()){
            return '0';
        }
        return remove(header.getNext());
    }

    public char removeLast(){
        if(isEmpty()){
            return '0';
        }
        return remove(trailer.getPrev());
    }

    private char remove(DnaNode node){
        DnaNode prev = node.getPrev();
        DnaNode next = node.getNext();

        prev.setNext(next);
        next.setPrev(prev);
        size--;

        return node.getDna();
    }

    public void printlist(){
        if(isEmpty()){
            System.out.println("a lista esta vazia!");
        }
        else{
            System.out.println("\na lista:");

            DnaNode start = header.getNext();

            while(start != trailer){
                System.out.printf( ""+ start.getDna());
                start = start.getNext();
            }

            System.out.printf("\ntamanho: " + size + "\n");
        }
    }

    // DN = A;
    // DA = N;
    // ND = A;
    // NA = D;
    // AD = N;
    // AN = D;
    // METODO PRINCIPAL PARA O TRABALHO:
    public void DnaSimp() {
    
        
        long tempoInicial = System.currentTimeMillis();
        DnaNode current = header.getNext();
        
        while(current != trailer.getPrev()){
            
            if(current.getDna() == 'D' && current.getNext().getDna() == 'N'){
                // Encontrou uma sequência "DN", vamos substituí-la por 'A'
                this.add('A');
                remove(current.getNext()); 
                remove(current);
                current = header.getNext();
            }
            else if(current.getDna() == 'D' && current.getNext().getDna() == 'A'){
                // Encontrou uma sequência "DA", vamos substituí-la por 'N'
                this.add('N');
                remove(current.getNext()); 
                remove(current);
                current = header.getNext();
            }
            else if(current.getDna() == 'N' && current.getNext().getDna() == 'D'){
                // Encontrou uma sequência "ND", vamos substituí-la por 'A'
                this.add('A');
                remove(current.getNext()); 
                remove(current);
                current = header.getNext();
            }
            else if(current.getDna() == 'N' && current.getNext().getDna() == 'A'){
                // Encontrou uma sequência "NA", vamos substituí-la por 'D'
                this.add('D');
               remove(current.getNext()); 
               remove(current);
               current = header.getNext();
            }
            else if(current.getDna() == 'A' && current.getNext().getDna() == 'N'){
                // Encontrou uma sequência "AN", vamos substituí-la por 'D'
                this.add('D');
                remove(current.getNext()); 
                remove(current);
                current = header.getNext();
            }
            else if(current.getDna() == 'A' && current.getNext().getDna() == 'D'){
                // Encontrou uma sequência "AD", vamos substituí-la por 'N'
                this.add('N');
                remove(current.getNext()); 
                remove(current);
                current = header.getNext();
            }
            else{
                current = current.getNext();
            }
        }
        
        long tempoFinal = System.currentTimeMillis();
        long tempoTotal = tempoFinal - tempoInicial;
        double segundos = (double) tempoTotal / 1000.0;

        System.out.println("Tempo de execução em segundos: " + segundos);
        

    } 
    
    // LEITOR DE ARQUIVO TXT
    public void LerArquivo(String arq) throws IOException{
       
        long tempoInicial = System.nanoTime();
        String arquivo = arq;

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
           
            int caractereLido;
            while ((caractereLido = br.read()) != -1) {
                char charLido = (char) caractereLido;
                if (isEmpty()) {
                    this.addFirst(charLido);
                } else {
                    this.add(charLido);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // Lançar a exceção novamente para quem chama o método
        }

        long tempoFinal = System.nanoTime();
        long nanossegundosDecorridos = tempoFinal - tempoInicial;
        double milissegundosDecorridos = (double) nanossegundosDecorridos / 1_000_000.0;

        System.out.println("Tempo decorrido para ler o arquivo: " + milissegundosDecorridos + " segundos");
    }
    


}

 