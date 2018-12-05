package kreuzung;


import kreuzung.Kreuzung;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
/**
 *
 * @author Ba Tue Freddy Tran
 */
public class gibArrayListeAus implements Runnable{
    
    Kreuzung kreuzung = new Kreuzung();
    private Lock lock;
    private Condition condition;
    
    /**
     *  Konstruktor für die Klasse gibArrayListeAus.
     * @param kreuzung - Kreuzung die behandelt wird.
     * @param lock - Lock Objekt
     * @param condition - Condition Objekt
     */
    public gibArrayListeAus(Kreuzung kreuzung, Lock lock, Condition condition){
        this.kreuzung = kreuzung;
        this.lock = lock;
        this.condition = condition;
    }
    
   
    @Override
    public void run() {
        
        try{
            lock.lock();
            System.out.println("Thread gibArrayListeAus wartet auf CreateVerkehrsteilnehmer Thread");            
            condition.await();
            System.out.println("**************************************");
            System.out.println("Thread gibs ArrayListeAus startet jetzt:");
            System.out.println("Hier ist die Endliste.");
            System.out.println("**************************************");
            toString();
            condition.signal();
            condition.awaitUninterruptibly();
            toString();
            condition.signal();
            condition.awaitUninterruptibly();
            toString();
        }catch(InterruptedException e){
            System.out.println("Thread wurde interrupted.");
        }finally{
            lock.unlock();
        }
        
    }
    /**
     * 
     * @return Verkehrsteilnehmer
     */
    public String toString(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>Status der Kreuzung<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("");
        if(kreuzung.Verkehrsteilnehmer.isEmpty() == true){
            System.out.println("An der Ampel steht kein Teilnehmer mehr");
        }else if(Kreuzung.getAutoAmpel() == 1){
                System.out.println("AMPELPAAR: NORDSUED IST GRÜN");
            }else if(Kreuzung.getAutoAmpel() == 2){
                System.out.println("AMPELPAAR: WESTOST IST GRÜN");
            }
        
            for(int i = 0; i < Kreuzung.Verkehrsteilnehmer.size(); i++){
                System.out.println(Kreuzung.Verkehrsteilnehmer.get(i).toString());
            }    
        return "";
    }
    
}
