
import kreuzungsTeilnehmer.CreateVerkehrsteilnehmer;
import kreuzung.gibArrayListeAus;
import kreuzung.VerwalteKreuzung;
import kreuzung.Kreuzung;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Ba Tue Freddy Tran
 */
public class Main {
    
    /**
     *
     * @param args - Main Methode.
     */
    public static void main(String[] args) {
        Kreuzung kreuzung = new Kreuzung();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        
        /**
         * Thread, welcher zufällig Verkehrsteilnehmer an der Kreuzung erscheinen
         * lässt.
         */
        Thread t1 = new Thread(new CreateVerkehrsteilnehmer(kreuzung, lock, condition));
        t1.start();
        
        /**
         * Thread der alle Verkehrsteilnehmer an der Kreuzung ausgibt.
         */
        Thread showTeilnehmer = new Thread(new gibArrayListeAus(kreuzung, lock, condition));
        showTeilnehmer.start();
        
        /**
         * Thread, der die einzelnen Verkehrsteilnehmer an der Kreuzung verwaltet.
         */
        Thread manageKreuzung = new Thread(new VerwalteKreuzung(kreuzung, lock, condition));
        manageKreuzung.start();
        
        
    }
}
