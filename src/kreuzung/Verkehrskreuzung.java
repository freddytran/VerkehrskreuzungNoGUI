package kreuzung;

import kreuzungsTeilnehmer.Vehicle;

/**
 *
 * @author Ba Tue Freddy Tran
 */
public interface Verkehrskreuzung {
    
    /**
     *  Fügt einen Verkehrsteilnemer der Kreuzung hinzu (ArrayListe).
     * @param vehicle- Vehicle, dass der Verkehrsteilnehmerliste als Beobachter hinzugefügt wird
     */
    void addBeobachter(Vehicle vehicle);
    
    /**
     *  Entfernt einen Verkehrsteilnehmer von der Kreuzung (ArrayListe).
     * @param vehicle - Vehicle, dass von der Verkehrsteilnehmerliste entfernt wird.
     */
    void removeBeobachter(Vehicle vehicle);
    
    /**
     *  Benachrichtigt alle Beobachter über eine Änderung.
     * Hier werden alle Beobachter benachrichtigt, wenn sich die Ampeln ändern.
     */
    void notifyAlleBeobachter();
    
    /**
     *  Diese Methode gibt alle Eigenschaften der einzelnen Verkehrsteilnehmer aus.
     * @return Eigenschaften des Verkehrsteilnehmer.
     */
    @Override
    String toString();
}
