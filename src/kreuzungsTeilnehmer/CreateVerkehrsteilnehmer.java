package kreuzungsTeilnehmer;


import kreuzungsTeilnehmer.Fussgaenger;
import kreuzungsTeilnehmer.Fahrrad;
import kreuzungsTeilnehmer.Auto;
import kreuzung.Kreuzung;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import kreuzung.Kreuzung;

/**
 *
 * @author Ba Tue Freddy Tran
 * Das hier ist der Thread, der zufällig Verkehrsteilnehmer erstellt.
 */
public class CreateVerkehrsteilnehmer implements Runnable {
    Kreuzung kreuzung = new Kreuzung();
    private Lock lock;
    private Condition condition;
    
    
    /**
     * Konstruktor für die Klasse CreateVerkehrsteilnehmer
     * @param kreuzung - Kreuzung die behandelt wird.
     * @param lock - Lock Objekt
     * @param condition - Condition Objekt
     */
    public CreateVerkehrsteilnehmer(Kreuzung kreuzung, Lock lock, Condition condition){
    
        this.kreuzung = kreuzung;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        int i = 0;
        
        while(i != 5){
            /**
             * Zufallsvariablen
             */
            int zufallIntention;
            int zufallPosition;
            int zufallVehicle;
            int zufallIntentionFuss;
            int zufallPositionFuss;
            
            /**
             * Hier werden die Zufallsvariablen mithilfe von Math.random() initialisiert
             * Math * random() * Anzahl der möglichen Zahlen beschränkt den Wertebereich.
             * Hier wird der Wertebereich also auf 0 bis 3 gesetzt.
            */
            zufallIntention = (int) (Math.random() * 3) + 5;
            zufallPosition = (int) (Math.random() * 4);
            zufallIntentionFuss = (int) (Math.random() * 4) + 10;
            zufallPositionFuss = (int) (Math.random() * 4) + 20;
            /**
             * Hier Wertebereich von 0 bis 2
             */
            zufallVehicle = (int) (Math.random() * 3);
            
            /**
             * Switch - Anweisung, um zu entscheiden welches Vehicle erstellt wird.
             */
            switch(zufallVehicle){
                /**
                 * Case 0 = Auto wird erstellt mit zufälliger Position und Intention
                 */
                case 0: Auto auto = new Auto(zufallPosition, zufallIntention, Vehicle.STATE.WARTET_AMPEL);
                        kreuzung.addBeobachter(auto);
//                        kreuzung.toString();
//                        System.out.println("");
//                        System.out.println("Fertig mit Ausgabe der aktuellen Liste");
//                        System.out.println("**************************************");
                        break;
                /**
                 * Case 1 = Fahrradfahrer wird erstellt mit zufälliger Position und Intention
                 */
                case 1: Fahrrad fahrrad = new Fahrrad(zufallPosition, zufallIntention, Vehicle.STATE.WARTET_AMPEL);
                        kreuzung.addBeobachter(fahrrad);
//                        kreuzung.toString();
//                        System.out.println("");
//                        System.out.println("Fertig mit Ausgabe der aktuellen Liste");
//                        System.out.println("**************************************");
                        break;
                /**
                 * Case 2 = Fussgaenger wird erstellt mit zufälliger Position und Intention
                 */
                case 2: Fussgaenger fussgaenger = new Fussgaenger(zufallPositionFuss, zufallIntentionFuss, Vehicle.STATE.WARTET_AMPEL);
                        kreuzung.addBeobachter(fussgaenger);
//                        kreuzung.toString();
//                        System.out.println("");
//                        System.out.println("Fertig mit Ausgabe der aktuellen Liste");
//                        System.out.println("**************************************");
                        break;
                /**
                 * Default - Anweisung, falls was schief läuft.
                 */
                default: System.out.println("Fehler bei der Erstellung des Verkehrsteilnehmer!");
            }
            
            i++;
        }
        
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
