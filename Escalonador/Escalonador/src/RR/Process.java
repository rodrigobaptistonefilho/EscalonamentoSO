package RR;

/**
 *
 * @author Rodrigo
 */
public class Process{
    String id;
    int tempo;
    int status;
    int cont;
    
    public Process(){
        this.id = " ";
        this.tempo = 0;
        this.status = 0;
        this.cont = 0;
    }
    
    public Process(String id, int tempo){
        this.id = id;
        this.tempo = tempo;
        this.status = 0;
        this.cont = 0;
    }
}
