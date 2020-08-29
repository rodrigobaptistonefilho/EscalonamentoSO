package prioD;

/**
 *
 * @author Rodrigo
 */

public class Process {
    String id;
    int tempo;
    int status;
    int prioridade;
    int cont;
    
    public Process(String id, int tempo, int prioridade){
        this.id = id;
        this.tempo = tempo;
        this.status = 0;
        this.prioridade = prioridade; 
        this.cont = 0;
    }
}
