package kreuzung;


import kreuzung.Kreuzung;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author Ba Tue Freddy Tran
 */
public class VerwalteKreuzung implements Runnable {

    Kreuzung kreuzung = new Kreuzung();
    private Lock lock;
    private Condition condition;
    /**
     *  Konstruktor für den Thread VerwalteKreuzung.
     *  Das Wichtigste ist, dass hier die Ampel gesetzt wird.
     * @param kreuzung - Kreuzung die behandelt wird.
     * @param lock - Lock Objekt
     * @param condition - Condition Objekt
     */
    public VerwalteKreuzung(Kreuzung kreuzung, Lock lock, Condition condition){
        this.kreuzung = kreuzung;
        this.lock = lock;
        this.condition = condition;
        
    };
    
    @Override
    public void run() {
        try{
            lock.lock();
            System.out.println("Thread VerwalteKreuzung wartet auf CreateVerkehrsteilnehmer Thread");
            System.out.println("**************************************");
            condition.await();
            System.out.println("");
            System.out.println("**************************************");
            System.out.println("Thread VerwalteKreuzung startet jetzt:");
            System.out.println("**************************************");
            /**
             * Hier wird die Methode notifyAlleBeobachter aus der KLasse Kreuzung aufgerufen.
             */
            Kreuzung.setAutoAmpel(1);
            condition.signal();
            condition.await(2000, TimeUnit.MILLISECONDS);
            kreuzung.notifyAlleBeobachter();
            Kreuzung.setAutoAmpel(2);
            condition.signal();
            condition.await(2000, TimeUnit.MILLISECONDS);
            kreuzung.notifyAlleBeobachter();
            System.out.println("Thread VerwalteKreuzung ist fertig.");
        }catch(InterruptedException e){
            System.out.println("Thread wurde interrupted.");
        }finally{
            lock.unlock();
        }
    } 
}
