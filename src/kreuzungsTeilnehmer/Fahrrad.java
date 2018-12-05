package kreuzungsTeilnehmer;


import kreuzungsTeilnehmer.Vehicle;

/**
 *
 * @author Ba Tue Freddy Tran
 */
public class Fahrrad extends Vehicle{
    static int fahrradCounter = 1;
    
    public Fahrrad(){
    
    }

    /**
     * 2.Konstruktor, indem der Name dynamisch mithilfe der statischen Counter - Variable
     * erstellt wird.
     * @param position - Position des Fahrrads
     * @param intention- Intention des Fahrrads
     * @param state - Status des Fahrrads
     */
    public Fahrrad(int position, int intention, STATE state){
        String fahrradName = String.format("Fahrrad %d", fahrradCounter);
        this.setName(fahrradName);
        this.setPosition(position);
        this.setIntention(intention);
        this.setCurrentState(state);
        fahrradCounter++;
    }
}
