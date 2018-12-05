package kreuzungsTeilnehmer;


import kreuzungsTeilnehmer.Vehicle;

/**
 *
 * @author Ba Tue Freddy Tran
 */
public class Auto extends Vehicle{
    static int autoCounter = 1;
    
    public Auto(){
    
    }
    
    /**
     * 2.Konstruktor, indem der Name dynamisch mithilfe der statischen Counter - Variable
     * erstellt wird.
     * @param position - Position des Autos
     * @param intention- Intention des Autos
     * @param state - Status des Autos
     */
    public Auto(int position, int intention, STATE state){
        String autoName = String.format("Auto %d", autoCounter);
        this.setName(autoName);
        this.setPosition(position);
        this.setIntention(intention);
        this.setCurrentState(state);
        autoCounter++;
    }
    
}
