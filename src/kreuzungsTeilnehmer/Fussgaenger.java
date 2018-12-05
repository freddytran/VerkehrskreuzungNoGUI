package kreuzungsTeilnehmer;


import kreuzungsTeilnehmer.Vehicle;

/**
 *
 * @author Ba Tue Freddy Tran
 */
public class Fussgaenger extends Vehicle{
    static int fussCounter = 1;
    
    public enum WALK{NW_NACH_NO, NW_NACH_SW, NO_NACH_NW, NO_NACH_SO, SO_NACH_NO,
                      SO_NACH_SW, SW_NACH_SO, SW_NACH_NW};
    
    public Fussgaenger(){
    
    }
    
    /**
     * 2.Konstruktor, indem der Name dynamisch mithilfe der statischen Counter - Variable
     * erstellt wird.
     * @param position - Position des Fussgaengers
     * @param intention- Intention des Fussgaengers
     * @param state - Status des Fussgaengers
     */
    public Fussgaenger(int position, int intention, STATE state){
        String fussName = String.format("Fussgaenger %d", fussCounter);
        this.setName(fussName);
        this.setPosition(position);
        this.setIntention(intention);
        this.setCurrentState(state);
        fussCounter++;
    }
}
