package kreuzungsTeilnehmer;


import kreuzung.Kreuzung;
import java.util.ArrayList;


/**
 *
 * @author Ba Tue Freddy Tran
 */
public class Vehicle implements Beobachter {
    Kreuzung kreuzung = new Kreuzung();
    private String name;
    private int position;
    private int intention;
    public enum STATE{WARTET_AMPEL, WARTET_KREUZUNG, FAEHRT};
    
    private STATE currentState;

    /**
     * Standard Konstruktor der Klasse Vehicle.
     */
    public Vehicle(){
    
    };
    
    /**
     * 2. Konstruktor der Klasse Vehicle.
     * @param kreuzung
     */
    public Vehicle(Kreuzung kreuzung){
        this.kreuzung = kreuzung;
        /*Hier wird der Verkehrsteilnehmer registriert*/
        this.kreuzung.addBeobachter(this);
        //this.kreuzung.setAutoAmpel(kreuzung.getAutoAmpel());
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return the intention
     */
    public int getIntention() {
        return intention;
    }

    /**
     * @param intention the intention to set
     */
    public void setIntention(int intention) {
        this.intention = intention;
    }
    
    @Override
    public String toString(){
    
        return "Vehicle: " + this.getName() + 
               " Position: " + this.getPosition() + 
               " Intention: " + this.getIntention() + 
               " Current State: " + this.getCurrentState();
    }
    
    /**
     * Update - Methode die immer aufgerufen wird, wenn die notfifyAlleBeobachter - Methode
     * der KLasse Kreuzung aufgerufen wird. 
     * In dieser Methode wird der Wert der AutoAmpel geprüft: 
     * Ist der Wert 1 bedeutet es, dass das NordSüd - Ampelpaar grün ist.
     * Ist der Wert 2 bedeutet es, dass das WestOst - Ampelpaar grün ist.
     * Je nachdem, welcher Fall eintritt wird die dazugehörige Methode aus der Klasse
     * Kreuzung aufgerufen.
     * 
     */
    @Override
    public void update() {
        int newstate = Kreuzung.getAutoAmpel();
        
        if(newstate == 1){
            kreuzung.NordSuedGruen();
        }
        
        if(newstate == 2){
           kreuzung.WestOstGruen();
        }
    }

    /**
     * @return the currentState
     */
    public STATE getCurrentState() {
        return currentState;
    }

    /**
     * @param currentState the currentState to set
     */
    public void setCurrentState(STATE currentState) {
        this.currentState = currentState;
    }
}
