package prioD;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class App {    
    public static void main(String[] args) throws InterruptedException {
        List<Process> process = new ArrayList();
        List<Process> ready = new ArrayList();
        Process aux = null;
        
        Process p1 = new Process("p1",300,3);
        Process p2 = new Process("p2",250,2);
        Process p3 = new Process("p3",100,5);
        Process p4 = new Process("p4",200,8);
        Process p5 = new Process("p5",250,3);
        Process p6 = new Process("p6",150,1);
        Process p7 = new Process("p7",100,1);
        Process p8 = new Process("p8",200,4);
        Process p9 = new Process("p9",300,6);
        Process p0 = new Process("p0",200,1);
        
        process.add(p1);
        process.add(p2);
        process.add(p3);
        process.add(p4);
        process.add(p5);
        process.add(p6);
        process.add(p7);
        process.add(p8);
        process.add(p9);
        process.add(p0);
        
        for(int i = 0; i < 2000; i += 30){
            if(!ready.isEmpty()){
                for(Process pr : ready){
                    if(pr.cont == 3){
                        ready.remove(pr);
                        break;
                    }
                }
            }
            
            System.out.print("\nt= " + i);
            for(Process proc : process){                
                if(proc.tempo <= i && proc.status == 0){
                    proc.status = 1;
                    ready.add(proc);
                }
            }
            
            System.out.print("\tExec: ");
            if(ready.isEmpty()){
                System.out.println("Nenhuma");
            }else{
                aux = getMaior(ready);
                aux.prioridade--;
                aux.cont++;
                System.out.println(aux.id +  "\tPriority: " + aux.prioridade);
                for(Process proc : ready){
                    if(!proc.id.equals(aux.id))
                        proc.prioridade++;
                }
                ready.remove(aux);
                printProcess(ready, aux);
                ready.add(aux);
                aux = null;
            }
            
            System.out.println("");
        }
    }
    
        public static Process getMaior(List<Process> vetor){
        int x = 0;
        Process y = null;
        for(Process process : vetor){
            if(process.prioridade > x){
                x = process.prioridade;
                y = process;
            }
        }
        return y;
    }
    
    public static void printProcess(List<Process> vetor, Process x){
        System.out.print("Fila: ");
            if(vetor.isEmpty()){
                System.out.println("Empty");
            }else{
                for(Process process : vetor){
                    System.out.println(process.id + "\t");
                }
            }  
    }
}
