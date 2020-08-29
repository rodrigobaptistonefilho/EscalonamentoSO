package RR;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Rodrigo
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        List<Process> process = new ArrayList();
        Queue<Process> ready = new LinkedList<Process>();
        String exec = "null";
        
        Process p1 = new Process("p1",300);
        Process p2 = new Process("p2",250);
        Process p3 = new Process("p3",100);
        Process p4 = new Process("p4",200);
        Process p5 = new Process("p5",250);
        Process p6 = new Process("p6",150);
        Process p7 = new Process("p7",100);
        Process p8 = new Process("p8",200);
        Process p9 = new Process("p9",300);
        Process p0 = new Process("p0",200);
        
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
        
        int quantum = 30;
        
        for(int i = 0; i < 2000; i += 30){
            System.out.print("\nTempo: " + i);
            for(Process proce : process){    
                if(proce.tempo <= i && proce.status == 0){
                    proce.status = 1;
                    ready.offer(proce);
                }
            }
            
            System.out.print("\tExec: ");
            if(quantum > 0){
                if(exec.equals("null")){
                    if(!ready.isEmpty()){
                        exec = ready.poll().id;
                        System.out.println(exec);
                        quantum -= 10;
                    }else{
                        System.out.println("Nenhuma");
                    }
                }else{
                    System.out.println(exec);
                    quantum -= 10;
                }
            }else{
                if(!ready.isEmpty()){
                    quantum = 30;
                    exec = ready.poll().id;
                    System.out.println(exec);
                    quantum -= 10;
                }else{
                    System.out.println("Nenhuma");
                }
            }
            
            if(ready.isEmpty()){
                System.out.println("vazia");
            }else{
                for(Process p : ready){
                    System.out.println("" + p.id + "\t");
                }
            }
        }
    }
}
