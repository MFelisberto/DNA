

public class App {
    public static void main(String[] args) throws Exception {
       
        DoubleDnaList lista = new DoubleDnaList();
        
        lista.LerArquivo("C:\\Winreducer\\WinReducerEX100_x64\\WORK\\ISO\\PROGRAMAS\\DNA\\TrabALEst2\\src\\test02");
    
        lista.printlist();

        lista.DnaSimp();

        lista.printlist();
        
    }
}
 